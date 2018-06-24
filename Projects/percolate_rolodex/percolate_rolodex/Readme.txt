The Solution contains the following folder

---src
|   |--- __init__.py - this file will start the program
|   |--- normalizer.py - actual program to export the data to json
|   |--- util.py - utility code for normalizer
---test
|   |--- test files
---log
|   |--- log files for normalizer and util files
-data
|    |--- data.in - complete input data
|---output
     |--- result.txt - output text file

Prerequesites:
--------------
Python 2.7 preferable
Python Standard library - no external library dependancy

Validations:
-------------
Input requirement
    entry = [firstname , lastname, US phone number , color, 5 digit zip codes]
    line number starts from 0 to n

    format:
    1 = [lastname, firstname, phone number , color, zipcode]  - 5 items
    2 = [firstname lastname, color, zipcode, phone number] - 4 items
    3 = [firstname, lastname, zipcode, phone number, color] - 5 items

    invalid - any format other than the above should be marked invalid and proceed with next
    invalid - if phone number is not 10 digits(may contain alphanumerics characters)
    invalid - if zip code does not contain 5 digits

Output requirement
    valid json
        intended with two spaces
        keys should be sorted in ascending order
    entries - list of all valid entry , ascending alphabetical order by (lastname, firstname)
    errors - list of line numbers with error

example:
{
    "entries": [
        {
            "color": "yellow",
            "firstname": "James",
            "lastname": "Murphy",
            "phonenumber": "018-154-6474",
            "zipcode": "83880"
        },
        {
            "color": “light blue",
            "firstname": "Booker T.",
            "lastname": "Washington",
            "phonenumber": "373-781-7380",
            "zipcode": "87360"
        }
],
"errors": [
        1,
        3
    ]
}

