import unittest
import logging

from percolate_rolodex.percolate_rolodex.src import normalizer
from percolate_rolodex.percolate_rolodex.src import util

logging.basicConfig(filename='..\log\\normalizer.log', level=logging.INFO,filemode='w')
class TestNormalizer(unittest.TestCase):
    '''
    Test utility for the normalizer module
    :param test:
    :return:
    '''
    def test_normalizer(self):
        self.assertIs(len(util.ENTRIES_LIST),0)
        self.assertIs(len(util.ERRORS_LIST), 0)
        normalizer.main()
        self.assertIs(len(util.ENTRIES_LIST), 45)
        self.assertIs(len(util.ERRORS_LIST), 19)


if __name__ == '__main__':
    unittest.main()