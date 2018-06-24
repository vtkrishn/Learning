import logging
import unittest
from percolate_rolodex.percolate_rolodex.src import util

logging.basicConfig(filename='..\log\\normalizer.log', level=logging.INFO,filemode='w')
class TestUtil(unittest.TestCase):
    '''
    Test utility for the util module
    :param test:
    :return:
    '''

    def test_strip_new_line_character(self):
        output= util.strip_last_character(None)
        self.assertIs(output,None)

        output = util.strip_last_character('')
        self.assertIs(output, '')

        output = util.strip_last_character('a')
        self.assertIs(output, '')

        output = util.strip_last_character('abc\n')
        self.assertEqual(output, 'abc')

    def test_write_to_json(self):
        util.write_to_json(None, util.OUTPUT_FILE)
        with open(util.OUTPUT_FILE, util.OPEN_FOR_READ) as i:
            self.assertEquals('null',i.readlines()[0])

        util.write_to_json([], util.OUTPUT_FILE)
        with open(util.OUTPUT_FILE, util.OPEN_FOR_READ) as i:
            self.assertIs(len(i.readlines()[0]),2)

        util.write_to_json(['test1', 'test2'],
                                                                   util.OUTPUT_FILE)
        with open(util.OUTPUT_FILE, util.OPEN_FOR_READ) as i:
            self.assertIs(len(i.readlines()[0]),2)

    def test_split_entry(self):
        list = util.split_entry(None, util.ENTRY_SPLIT)
        self.assertIs(len(list), 0)

        list = util.split_entry('', util.ENTRY_SPLIT)
        self.assertIs(len(list), 0)

        list = util.split_entry('1, 2, 3, 4',
                                                                        util.ENTRY_SPLIT)
        self.assertIs(len(list),4)

    def test_get_entry_object(self):
        output= util.get_entry_object(None, None, None, None, None)
        self.assertEqual(output,{'color': None, 'lastname': None, 'phonenumber': None, 'zipcode': None, 'firstname': None})

        output = util.get_entry_object('', '', '', '', '')
        self.assertEqual(output, {'color': '', 'lastname': '', 'phonenumber': '', 'zipcode': '', 'firstname': ''})

        output = util.get_entry_object('firstname', 'lastname', 'color', 'zipcode', 'phonenumber')
        self.assertEqual(output, {'color': 'color', 'lastname': 'lastname', 'phonenumber': 'phonenumber', 'zipcode': 'zipcode', 'firstname': 'firstname'})

    def test_create_output(self):
        output= util.create_output(None, None)
        self.assertIs(output['entries'],None)
        self.assertIs(output['errors'], None)

        output = util.create_output('', '')
        self.assertIs(output['entries'], '')
        self.assertIs(output['errors'], '')

        output = util.create_output('test1', 'test2')
        self.assertIs(output['entries'], 'test1')
        self.assertIs(output['errors'], 'test2')


    def test_custom_sort(self):
        list=None
        util.custom_sort(list, None, None)
        self.assertIs(list, None)

        list = [{'one' : 'A'}]
        util.custom_sort(list, None, None)
        self.assertIs(list, list)

        list = [{'one': 'A'}]
        util.custom_sort(list, '', '')
        self.assertIs(list, list)

        list = [{'one': 'A'}]
        util.custom_sort(list, 'some', 'two')
        self.assertIs(list, list)

        list=[
            {'color': 'aqua marine', 'lastname': 'Zill', 'phonenumber': '196 910 5548', 'zipcode': '97671', 'firstname': 'Annalee'},
            {'color': 'blue', 'lastname': 'Annalee', 'phonenumber': '905 329 2054', 'zipcode': '97296', 'firstname': 'Zill'}
        ]
        util.custom_sort(list, 'lastname', 'firstname')
        self.assertIs(list[0]['lastname'], 'Annalee')
        self.assertIs(list[1]['lastname'], 'Zill')

    def test_check_pattern(self):
        errors=None
        util.check_pattern(None,0, None, errors)
        self.assertIs(errors,None)

        util.check_pattern(None, -1, None, errors)
        self.assertIs(errors, None)

        util.check_pattern(['one', 'two', 'three', 'four'], 0, util.ENTRIES_LIST, util.ERRORS_LIST)
        self.assertEqual(util.ERRORS_LIST[0], 0)
        self.assertEqual(len(util.ENTRIES_LIST), 0)

        util.check_pattern(['Noah, Moench', '123123121', '232 695 2394', 'yellow'], 0, util.ENTRIES_LIST, util.ERRORS_LIST)
        self.assertEqual(util.ERRORS_LIST[0], 0)
        self.assertEqual(len(util.ENTRIES_LIST), 0)

        util.check_pattern(['Ria Tillotson', 'aqua marine', '97671', '196 910 5548'], 0, util.ENTRIES_LIST,
                           util.ERRORS_LIST)
        self.assertEqual(util.ERRORS_LIST[0], 0)
        self.assertEqual(len(util.ENTRIES_LIST), 1)

        util.check_pattern(['Annalee, Loftis', '97296', '905 329 ', 'blue'], 0, util.ENTRIES_LIST,
                           util.ERRORS_LIST)
        self.assertEqual(util.ERRORS_LIST[0], 0)
        self.assertEqual(len(util.ENTRIES_LIST), 1)

        util.check_pattern(['Liptak, Quinton', '(653) - 889 - 7235', 'yellow', '70703'], 0, util.ENTRIES_LIST,
                           util.ERRORS_LIST)
        self.assertEqual(util.ERRORS_LIST[0], 0)
        self.assertEqual(len(util.ENTRIES_LIST), 1)

    def test_firstname_pattern(self):
        self.assertFalse(util.FIRSTNAME_PATTERN.match(''))
        self.assertFalse(util.FIRSTNAME_PATTERN.match('one'))
        self.assertFalse(util.FIRSTNAME_PATTERN.match('one two'))
        self.assertIsNone(util.FIRSTNAME_PATTERN.match('annalee'))
        self.assertIsNone(util.FIRSTNAME_PATTERN.match(' annalee'))
        self.assertIsNone(util.FIRSTNAME_PATTERN.match('annalee '))
        self.assertIsNone(util.FIRSTNAME_PATTERN.match('1annalee'))
        self.assertIsNone(util.FIRSTNAME_PATTERN.match('#annalee'))
        self.assertIsNone(util.FIRSTNAME_PATTERN.match('annalee1'))
        self.assertIsNone(util.FIRSTNAME_PATTERN.match('annalee$'))
        self.assertIsNone(util.FIRSTNAME_PATTERN.match('annaleeZ'))
        self.assertIsNone(util.FIRSTNAME_PATTERN.match('AnnaleeZ'))
        self.assertIsNone(util.FIRSTNAME_PATTERN.match('Annalee '))
        self.assertIsNone(util.FIRSTNAME_PATTERN.match('Annalee%'))
        self.assertIsNone(util.FIRSTNAME_PATTERN.match('Annalee%we'))
        self.assertTrue(util.FIRSTNAME_PATTERN.match('Annalee'))
        self.assertTrue(util.FIRSTNAME_PATTERN.match('Annalee T.'))


    def test_lastname_pattern(self):
        self.assertFalse(util.LASTNAME_PATTERN.match(''))
        self.assertFalse(util.LASTNAME_PATTERN.match('one'))
        self.assertFalse(util.LASTNAME_PATTERN.match('one two'))
        self.assertIsNone(util.LASTNAME_PATTERN.match('annalee'))
        self.assertIsNone(util.LASTNAME_PATTERN.match(' annalee'))
        self.assertIsNone(util.LASTNAME_PATTERN.match('annalee '))
        self.assertIsNone(util.LASTNAME_PATTERN.match('1annalee'))
        self.assertIsNone(util.LASTNAME_PATTERN.match('#annalee'))
        self.assertIsNone(util.LASTNAME_PATTERN.match('annalee1'))
        self.assertIsNone(util.LASTNAME_PATTERN.match('annalee$'))
        self.assertIsNone(util.LASTNAME_PATTERN.match('annaleeZ'))
        self.assertIsNone(util.LASTNAME_PATTERN.match('AnnaleeZ'))
        self.assertIsNone(util.LASTNAME_PATTERN.match('Annalee '))
        self.assertIsNone(util.LASTNAME_PATTERN.match('Annalee%'))
        self.assertIsNone(util.LASTNAME_PATTERN.match('Annalee%we'))
        self.assertIsNone(util.LASTNAME_PATTERN.match('Annalee T.'))
        self.assertTrue(util.LASTNAME_PATTERN.match('Annalee'))

    def test_phone_pattern(self):
        self.assertFalse(util.PHONE_PATTERN.match(''))
        self.assertFalse(util.PHONE_PATTERN.match('one'))
        self.assertFalse(util.PHONE_PATTERN.match('1234'))
        self.assertFalse(util.PHONE_PATTERN.match('123434534535345345'))

        self.assertTrue(util.PHONE_PATTERN.match('196 910 5548'))
        self.assertTrue(util.PHONE_PATTERN.match('(653)-889-7235'))

    def test_zipcode_pattern(self):
        self.assertFalse(util.ZIPCODE_PATTERN.match(''))
        self.assertFalse(util.ZIPCODE_PATTERN.match('123'))
        self.assertFalse(util.ZIPCODE_PATTERN.match('erewr'))
        self.assertTrue(util.ZIPCODE_PATTERN.match('12334'))

    def test_color_pattern(self):
        self.assertFalse(util.COLOR_PATTERN.match(''))
        self.assertFalse(util.COLOR_PATTERN.match('123'))
        self.assertTrue(util.COLOR_PATTERN.match('orange'))
        self.assertTrue(util.COLOR_PATTERN.match('Green'))
        self.assertTrue(util.COLOR_PATTERN.match('whitish orange'))

    def test_add_to_error(self):
        error_list=None
        util.add_to_error(error_list, 0)
        self.assertIs(error_list,None)

        error_list = []
        util.add_to_error(error_list, -1)
        self.assertIs(len(error_list),0)

        error_list = []
        util.add_to_error(error_list, 1)
        self.assertIs(len(error_list), 1)

        error_list = [1,2,3,4]
        util.add_to_error(error_list, 2345)
        self.assertIs(len(error_list), 5)

    def test_util_check_arguments(self):
        # 'test with test argument = 0'
        data_file,output_file = util.check_arguments(0)
        self.assertIs(data_file,0)
        self.assertIs(output_file,0)

        # 'test with test argument = 1'
        data_file,output_file= util.check_arguments(1)
        self.assertIs(data_file, util.DATA_FILE)
        self.assertIs(output_file, util.OUTPUT_FILE)

        # 'test with test argument = 2'
        util.ARGUMENTS = ['filename', 'argument1']
        data_file,output_file = util.check_arguments(2)

        self.assertIs(data_file, 'argument1')
        self.assertIs(output_file, util.OUTPUT_FILE)

        # 'test with test argument = 3'
        util.ARGUMENTS = ['filename', 'argument1', 'argument2']
        data_file,output_file = util.check_arguments(3)
        self.assertIs(data_file, 'argument1')
        self.assertIs(output_file, 'argument2')

        # 'test with test argument = 4'
        util.ARGUMENTS = ['filename', 'argument1', 'argument2', 'argument3']
        data_file,output_file = util.check_arguments(4)
        self.assertIs(data_file, 'argument1')
        self.assertIs(output_file, 'argument2')

if __name__ == '__main__':
    unittest.main()