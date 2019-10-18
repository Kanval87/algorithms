#! /bin/bash

merge(){
    local p=$1
    local q=$(expr $2 + 1)
    local r=$3
    local leftArray=(${inputArray[@]:$p:$(expr $q - $p)})
    local rightArray=(${inputArray[@]:$q:$(expr $(expr $r - $q) + 1)})
    echo "merge 1.  p -> $p : q -> $q : r -> $r : leftArray -> ${leftArray[@]} : rightArray -> ${rightArray[@]} : inputarray -> ${inputArray[@]}"
    local i=0
    local j=0
    local k=$p
    while [[ $k -le $r ]]
        do
            echo "merge 2. i -> $i : j -> $j : k -> $k : r -> $r : leftArray[i] -> ${leftArray[i]} : rightArray[j] -> ${rightArray[j]} : inputArray[@] -> ${inputArray[@]}"
            if [[  ${leftArray[i]} -gt ${rightArray[j]} ]]
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
        echo "merge 3. -> return  p -> $p : q -> $q : r -> $r : leftArray -> ${leftArray[@]} : rightArray -> ${rightArray[@]} : inputarray -> ${inputArray[@]}"
}


mergeSort(){
    local p=$1
    local r=$2
    local diff=$(expr $r - $p)
    echo "mergesort 1. -> p-> $p  : r -> $r : diff -> $diff"
    if [ $diff -ge 1 ]
    then
        local q=$(expr $(expr $r + $p) / 2)
        local qNext=$(expr $q  + 1)
        echo "mergesort 2. -> p-> $p : q -> $q : qNext -> $qNext  : r -> $r | ${inputArray[$r]} : array -> ${inputArray[@]}"
        mergeSort $p $q
        mergeSort $qNext $r
        merge $p $q $r
    else
        echo "return mergesort 2. -> p-> $p  : r -> $r : array -> ${inputArray[@]}"
        return
    fi    
}


inputArray=(1 2 3 6 5 4)
mergeSort  0 $(expr ${#inputArray[@]} - 1)