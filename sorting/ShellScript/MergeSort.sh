#! /bin/bash

merge(){
    local p=$1
    local q=$2
    local r=$3
    local array=(${@:4})
    echo "merge -> ${array[@]} 
    $p $q $r"
}


mergeSort(){
    local p=$1
    local r=$2
    local localArray=(${@:3})
    local diff=$(expr $r - $p)
    echo $diff
    if [ $diff -gt 0 ]
    then
        q=$(expr $(expr $r + $p) / 2)
        mergeSort $p $q $localArray
        mergeSort $(expr $q + 1) $r $localArray
        merge $p $q $r $localArray
    else
        return
    fi    
}


inputArray=(1 2 3 4 5 6)
mergeSort  0 ${#inputArray[@]} ${inputArray[@]}

