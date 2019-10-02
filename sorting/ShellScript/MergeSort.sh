#! /bin/bash

merge(){
    local array=$1
    local p=$2
    local q=$3
    local r=$4
    echo "$array $p $q $r"
}


mergeSort(){
    local p=$1
    local r=$2
    local localArray=(${@:3})
    echo "-> 
            ${localArray[@]}
            $p
            $r
            ${#localArray[@]}"
    if [ ${#localArray[@]} -gt 2 ]
    then
        echo 'more than 2'
    else
        echo 'less than 2'
    fi    
}


inputArray=(1 2 3 4 5 6)
mergeSort  0 ${#inputArray[@]} ${inputArray[@]}

