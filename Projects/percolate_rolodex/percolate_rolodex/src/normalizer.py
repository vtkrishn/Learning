import logging
import sys
import util

def main():
    """
    Main function to be called from external program
    Usage : normalize.py <datafile> <outputfile>
    :return:
    """

    entries = util.ENTRIES_LIST
    errors = util.ERRORS_LIST

    try:
        data_file, output_file = util.check_arguments(len(sys.argv))
        logging.info('data file set to :: '+ data_file)
        logging.info('output file set to :: '+ output_file)

        #opening the data file
        with open(data_file, util.OPEN_FOR_READ) as data:
            #line number for the error reporting
            line_count = 0

            #for each line
            for entry in data.readlines():
                #strip the \n character
                entry = util.strip_last_character(entry)
                #add to the list by splitting by ,
                entry_list = util.split_entry(entry, util.ENTRY_SPLIT)

                flag=util.check_pattern(entry_list, line_count,entries,errors)
                if flag == False:
                    line_count = line_count + 1
                    # skip this loop
                    continue

                logging.info(str(line_count) + ' [VALID] - [' + ",".join(entry_list) + ']')
                #increment the line count
                line_count=line_count+1

            #sort by lastname and then firstname
            util.custom_sort(entries,'lastname','firstname')

            #get the output
            output = util.create_output(entries,errors)

            #write the output in json format
            util.write_to_json(output, output_file)

    except IOError,e:
        logging.error('IOError occured :: ', e.message)

if __name__ == '__main__':
    main()


