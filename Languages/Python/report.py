import re
with open('test-report.xml','r') as f:
    for line in f:
        if re.search('testcase',line):
            line = line.replace(',', '')
            name = re.findall( 'name="(.*?)" ' ,line)
            time = re.findall( 'time="(.*?)"' ,line)
            if len(name) > 0 and len(time) > 0:
                print name[0][:50] + ' , ' + time[0]