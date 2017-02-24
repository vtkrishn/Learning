SQL Basics
1) SELECT population FROM world
  WHERE name = 'Germany'

2) SELECT name, population FROM world
  WHERE name IN ('Sweden', 'Norway', 'Denmark');

3) SELECT name, area FROM world
    WHERE area BETWEEN 200000 AND 250000

SQL world
2) SELECT name FROM world
WHERE population >= 200000000

3) SELECT name, GDP/population FROM world
WHERE population >= 200000000

4)select name ,population/1000000 from world where continent = 'South America'

5)select name ,population from world where name in ('France','Germany','Italy')

6)select name from world where name like '%United%'

7)select name ,population,area from world where area > 3000000 or population >= 250000000

8) select name ,population,area from world where (area > 3000000 and population < 250000000) or (area < 3000000 and population > 250000000)

9)SELECT name, ROUND(population/1000000,2), ROUND(gdp/1000000000, 2)
FROM world
WHERE continent = 'South America'

10)SELECT name, ROUND(gdp/population, -3)
FROM world
WHERE gdp > 1000000000000

11)SELECT name,
       CASE WHEN continent = 'Oceania'  THEN 'Australasia'
            ELSE continent END
  FROM world
 WHERE name LIKE 'N%'

12)select name,
case
when continent = 'Europe' or continent = 'Asia' then 'Eurasia'
when continent in ('North America','South America','Caribbean') then 'America'
else continent
end
from world
where name like 'A%' or name like 'B%'

13)
SELECT name,
continent,
CASE
WHEN continent = 'Oceania' then 'Australasia'
WHEN continent = 'Eurasia' or name = 'Turkey' then 'Europe/Asia'
WHEN continent = 'Caribbean' and name like 'B%' then 'North America'
WHEN continent = 'Caribbean' and name not like 'B%' then 'South America'
else
continent
END
  FROM world
WHERE tld IN ('.ag','.ba','.bb','.ca','.cn','.nz','.ru','.tr','.uk')
order by name

SQL NOBEL
1) SELECT yr, subject, winner
  FROM nobel
 WHERE yr = 1950

2)SELECT winner
  FROM nobel
 WHERE yr = 1962
   AND subject = 'Literature'

3)select yr, subject from nobel where winner = 'Albert Einstein'

4)select winner from nobel where subject = 'Peace' and yr >= 2000

5)select yr, subject, winner from nobel where subject = 'Literature' and yr >= 1980 and yr <= 1989

6)SELECT * FROM nobel
 WHERE winner in ('Theodore Roosevelt','Woodrow Wilson','Jimmy Carter');

7)SELECT winner FROM nobel
 WHERE winner like 'John%'

8)select * from nobel where (subject = 'Physics' and yr =1980) or (subject = 'Chemistry' and yr=1984)

9)select * from nobel where yr =1980 and subject not in ('Chemistry','Medicine')

10)select * from nobel where (subject = 'Medicine' and yr < 1910) or (subject ='Literature' and yr >= 2004)

11)select * from nobel where winner = 'PETER GR%NBERG'

12)select * from nobel where winner like 'EUGENE O%NEILL'

13)select winner,yr,subject from nobel where winner like 'Sir%' order by yr desc,winner

14)SELECT winner, subject
FROM nobel
WHERE yr=1984
ORDER BY subject IN ('Physics','Chemistry'),subject,winner
