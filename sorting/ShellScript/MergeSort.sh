#! /bin/bash

merge(){
    local p=$1
    local q=$2
    local r=$3
    local leftArray=${inputArray[@]:$p:$(expr $q - $p)}
    local rightArray=${inputArray[@]:$q:$(expr $(expr $r - $q) + 1)}
    local i=$p
    local j=$q
    local k=$p
    while [[ $k -lt $r ]]
        do
            if [[ ${leftArray[i]} -gt ${rightArray[j]} ]]
            then
                inputArray[k]=${leftArray[i]}
                i=$(expr $i + 1)
                k=$(expr $k + 1)
            else 
                inputArray[k]=${rightArray[j]}
                j=$(expr $j + 1)
                k=$(expr $k + 1)    
            fi
        done
    echo "merge  p -> $p : q -> $q : r -> $r : leftArray -> ${leftArray[@]} : rightArray -> ${rightArray[@]} : inputarray -> ${inputArray[@]}"
}


mergeSort(){
    local p=$1
    local r=$2
    local diff=$(expr $r - $p)
    if [ $diff -gt 1 ]
    then
        local q=$(expr $(expr $r + $p) / 2)
        local qNext=$(expr $q  + 1)
        echo "mergesort -> p-> $p : q -> $q : qNext -> $qNext  : r -> $r | ${inputArray[$r]} : array -> ${inputArray[@]}"
        mergeSort $p $q
        mergeSort $qNext $r
        merge $p $q $r
    else
        echo "return mergesort -> p-> $p  : r -> $r : array -> ${inputArray[@]}"
        return
    fi    
}


inputArray=(1 2 3 4 5 6)
mergeSort  0 $(expr ${#inputArray[@]} - 1)

