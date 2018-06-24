import logging
import sys
import json
import re

#these constants are used to inject values from outside as well as for constants
DATA_FILE='..\\data\\data.in'
OUTPUT_FILE='..\\output\\result.txt'
OPEN_FOR_READ='r'
OPEN_FOR_WRITE='w'
FIRSTNAME_SPACE_PATTERN = re.compile('^[A-Z][a-z]+ [A-Z][a-z]+$')
FIRSTNAME_PATTERN = re.compile('^[A-Z][a-z]+$|^[A-Z][a-z]+ [A-Z.]+$')
LASTNAME_PATTERN = re.compile('^[A-Z][a-z]+$')
PHONE_PATTERN = re.compile('^[0-9]{3} [0-9]{3} [0-9]{4}$|^\([0-9]{3}\)-[0-9]{3}-[0-9]{4}$')
ZIPCODE_PATTERN = re.compile('^[0-9]{5}$')
COLOR_PATTERN = re.compile('^[a-z]+ [a-z]+$|^[A-Za-z]+$')
JSON_INDENT=2
JSON_ENTRY_SEPARATOR=','
JSON_ATTRIBUTE_SEPARATOR=': '
ENTRY_SPLIT=', '

ARGUMENTS=sys.argv

ENTRIES_LIST=[]
ERRORS_LIST=[]

def check_arguments(arglength):
    '''
    This method will take argument length and populate the data file and output file
    :param arglength:
    :return data_file, output_file:
    '''
    try:
        if arglength == 0:
            logging.info('No arguments to process')
            return 0,0
        elif arglength == 1:
            # if no arguments passed then default the location
            data_file = DATA_FILE
            output_file = OUTPUT_FILE
        else:
            if arglength == 2:
                # if only one argument passed
                data_file = ARGUMENTS[1]
                output_file = OUTPUT_FILE
            elif arglength == 3:
                # if two arguments passed
                data_file = ARGUMENTS[1]
                output_file = ARGUMENTS[2]
            else:
                # if more arguments are passed
                data_file = ARGUMENTS[1]
                output_file = ARGUMENTS[2]
                logging.info('Extra parameters are ignored')
        return data_file, output_file
    except IndexError, e:
        logging.error('Error occured :: ' , e.message)


def check_pattern(entry_list, line_count, entries, errors):
    '''
    This method will take the entry list and then validates for the pattern
    :param entry_list:
    :param line_count:
    :param entries:
    :param errors:
    :return:
    '''

    # if the list entry_list_length is less than 4 ro greater than 5 then add it to errors list
    if entry_list is None or line_count < 0:
        # add to the errors list
        add_to_error(errors, line_count)
        if line_count < 0:
            logging.info(str(line_count) + ' [INVALID] - ' + ' length not valid  = ' + '1' if entry_list is None else str(len(entry_list)))
        else:
            logging.info(str(line_count) + ' [INVALID] - ' + ' Input not valid = [' + (
            '' if entry_list is None else ",".join(entry_list)) + ']')
        return False

    # get the entry_list_length of the list
    entry_list_length = len(entry_list)

    if entry_list_length == 4 \
            and FIRSTNAME_SPACE_PATTERN.match(entry_list[0]) \
            and COLOR_PATTERN.match(entry_list[1]) \
            and ZIPCODE_PATTERN.match(entry_list[2]) \
            and PHONE_PATTERN.match(entry_list[3]):
        # supporting  - [firstname lastname, color, zipcode, phone number] - 4 items
        first_name = split_entry(entry_list[0], ' ')[0]
        last_name = split_entry(entry_list[0], ' ')[1]
        color = entry_list[1]
        zip_code = entry_list[2]
        phone = entry_list[3]
        entries.append(get_entry_object(first_name, last_name, color, zip_code, phone))
    elif entry_list_length == 5 \
            and ZIPCODE_PATTERN.match(entry_list[2]) \
            and FIRSTNAME_PATTERN.match(entry_list[0]) \
            and LASTNAME_PATTERN.match(entry_list[1]) \
            and PHONE_PATTERN.match(entry_list[3]) \
            and COLOR_PATTERN.match(entry_list[4]):
        # supporting  - [firstname, lastname, zipcode, phone number, color] - 5 items
        zip_code = entry_list[2]
        first_name = entry_list[0]
        last_name = entry_list[1]
        phone = entry_list[3]
        color = entry_list[4]
        entries.append(get_entry_object(first_name, last_name, color, zip_code, phone))
    elif entry_list_length == 5 \
            and PHONE_PATTERN.match(entry_list[2]) \
            and FIRSTNAME_PATTERN.match(entry_list[0]) \
            and LASTNAME_PATTERN.match(entry_list[1]) \
            and COLOR_PATTERN.match(entry_list[3]) \
            and ZIPCODE_PATTERN.match(entry_list[4]):
        # supporting  - lastname, firstname, phone number , color, zipcode]  - 5 items
        phone = entry_list[2]
        first_name = entry_list[1]
        last_name = entry_list[0]
        color = entry_list[3]
        zip_code = entry_list[4]
        entries.append(get_entry_object(first_name, last_name, color, zip_code, phone))
    else:
        # add to the errors list
        add_to_error(errors, line_count)
        logging.info(str(line_count) + ' [INVALID] - ' + ' format not valid = [' + ",".join(entry_list) + ']')
        return False
    return True

def write_to_json(output, output_file):
    '''
    Write the output to json
    :param output:
    :param output_file:
    :return:
    '''
    with open(output_file, OPEN_FOR_WRITE) as out:
        # dump the json output with 2 space intendation and sorting based on keys
        json.dump(output, out, indent=JSON_INDENT,
                  separators=(JSON_ENTRY_SEPARATOR, JSON_ATTRIBUTE_SEPARATOR), sort_keys=True)


def custom_sort(entries,a,b):
    '''
    Sort the entries based on a and then b
    :param entries:
    :param a:
    :param b:
    :return:
    '''
    if entries == None or a == None or b == None or a == '' or b == '':
        return
    try:
        entries.sort(key=lambda e: (e[a], e[b]))
    except KeyError, e:
        return

def get_entry_object(firstname,lastname, color, zipcode, phone):
    '''
    This method returns an entry object populated with the corresponding parameters
    :param firstname:
    :param lastname:
    :param color:
    :param zipcode:
    :param phone:
    :return:
    '''
    return {
        'firstname' : firstname,
        'lastname' : lastname,
        'color' : color,
        'zipcode' : zipcode,
        'phonenumber' : phone
    }

def create_output(entries, errors):
    return {
        "entries": entries,
        "errors": errors
    };

def add_to_error(errors,linenumber):
    '''
    A method to append line numbers to the errors list
    :param linenumber:
    :return:
    '''
    if errors is None or linenumber < 0:
        return
    errors.append(linenumber)


def strip_last_character(str):
    '''
    This method with strip the last new line character for the string parameter
    :param str:
    :return:
    '''
    return None if str == None else ('' if str == '' else str[:-1])


def split_entry(str, pattern):
    '''
    Splits the string based on the character pattern
    :param str:
    :param pattern:
    :return:
    '''
    return '' if (str is None or str == '') else str.split(pattern)
