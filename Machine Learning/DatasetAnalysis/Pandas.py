# This Python 3 environment comes with many helpful analytics libraries installed
# It is defined by the kaggle/python docker image: https://github.com/kaggle/docker-python
# For example, here's several helpful packages to load in

import numpy as np # linear algebra
import pandas as pd # data processing, CSV file I/O (e.g. pd.read_csv)

# Input data files are available in the "../input/" directory.
# For example, running this (by clicking run or pressing Shift+Enter) will list the files in the input directory

from subprocess import check_output
print(check_output(["ls", "../input"]).decode("utf8"))

# Any results you write to the current directory are saved as output.
df = pd.read_csv('../input/gendermodel.csv', encoding='cp437')
df.head()

#Check for the missing values
print('The number of rows with Missing Values are: ')
df.isnull().any(axis=1).sum()

df.info() # get the info for the file

print(df['Survived'] , df['PassengerId']) #print the columns

print(df['PassengerId'].nunique()) #number or unique

# plot the columns
df['PassengerId'].plot()
df['Survived'].plot()

df[:5] # get the first five columns
df['PassengerId'][:2] #get 2 columns from PassengerId column

df[['PassengerId','Survived']] #get multiple columns
df[['PassengerId','Survived']][:5] #get multiple columns five columns

df['PassengerId'].value_counts() #like group by to aggregate the results
df['PassengerId'].value_counts().plot(kind='Bar') #to plot the bar
