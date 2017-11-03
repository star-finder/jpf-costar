#!/bin/bash

fname=$1

# Only call jpf on the files whose names start with "test_"
bname=`basename $fname`
if  [[ $bname == test_* ]] ;
then
    jpf $fname
fi


