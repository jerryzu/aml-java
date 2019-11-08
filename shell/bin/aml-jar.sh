#!/bin/bash
cd ../
java -jar lib/aml-1.0.jar -DWorkDay=20191013 -tcsv -f"work/"
cd work
tar -czvf aml.tar.gz *.csv
rm -rf ./*.csv
cd ../bin

cd ../
java -jar lib/aml-1.0.jar -DWorkDay=20191013 -txls -f"work/aml.xls"
cd work
tar -czvf aml.tar.gz *.xls
rm -rf ./*.xls
cd ../bin

