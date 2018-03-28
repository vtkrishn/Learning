#!/bin/bash

echo "****** Checking Versions ******"
bash --version | head -n1 | cut -f2-4 -d' '
ld --version | head -n1 | cut -f2- -d' '
gcc --version | head -n1
g++ --version | head -n1
ldd --version | head -n1
grep --version | head -n1
gzip --version | head -n1
cat /proc/version | cut -f1-3 -d' '
m4 --version | head -n1
make --version | head -n1
patch --version | head -n1
perl --version | cut -f3-5 -d' ' | head -n2 | tail -n1
sed --version | head -n1
tar --version | head -n1
makeinfo --version | head -n1
xz --version | head -n1
