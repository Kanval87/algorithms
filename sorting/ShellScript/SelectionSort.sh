#! /bin/bash 

inputArray=(1 2 3 4 5 6)
echo ${inputArray[@]}

j=0
while [ $j -lt ${#inputArray[@]} ]
    do
        echo "${inputArray[$j]}"
        variableA=${inputArray[$j]}
        variableB=${inputArray[$j]}
        i=$(expr $j + 1)
        while [ $i -lt ${#inputArray[@]} ]
            do
                echo " $variableA -lt ${inputArray[$i]} "
                if [[ $variableA -lt ${inputArray[$i]} ]] # double bracket drving from Bash
                then
                    variableB=$variableA
                    variableA=${inputArray[$i]}
                    inputArray[$i]=$variableB
                fi
                i=$(expr $i + 1)    
            done
        inputArray[j]=$variableA
        j=$(expr $j + 1)
    done
echo ${inputArray[@]}
