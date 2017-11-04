#!/bin/bash

fname=$1

# Only call jpf on the files whose names start with "test_"
bname=`basename $fname`
if  [[ $bname == test_* ]] ;
then
    printf '\n\n======================================================\n'
    printf 'Testing '$fname"\n\n"
    jpf $fname
fi


