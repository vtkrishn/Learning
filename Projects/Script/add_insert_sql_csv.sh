insertString='insert into mot_terr_dim_members_b ('
counter=1
for file in *.csv
do
	while read line; do
		#get the first column of the line
		val=`echo $line | cut -f1 -d,`
		#if the first column starts with the pattern
		if [[ $val == TERR_DIM_MEMBER_ID ]]
		then
			columns=`echo $line | awk -F , '{ print $1","$2","$3","$4","$5","$6","$7","$8","$9","$10","$11","$12","$13","$14","$15","$16","$17","$18","$19","$20","$21","$22","$23","$24","$25","$26","$27","$28 }'`
			columnString=$insertString$columns') values ('
			previousLine=$val
		elif [[ $val == $1* && $previousLine == 'TERR_DIM_MEMBER_ID' ]]
		then
			values=`echo $line | awk -F , -v q=\' ' { print $1","$2","$3","q$4q","$5","$6","$7","$8","$9","$10","$11","$12","$13","q$14q","q$15q","q$16q","q$17q","$18","$19","$20",sysdate,"q$22q",sysdate,"q$24q","q$25q","$26","$27","q$28q }'`
			echo $columnString $values '); --'$counter
			counter=$[$counter +1]
		else
			previousLine=''
		fi
	done<$file
done
