#! /bin/bash 

unsortedA=(1 2 3 4 5 6)
echo "Input array -> "${unsortedA[@]}

l=1 # 1 represents second element in array here
while [ $l -lt ${#unsortedA[@]} ]; # ${#unsortedA[@]}
    do 
        echo "$l iteration -> Array State : ${unsortedA[@]}"
        key=${unsortedA[$l]}
        i=$(expr $l - 1)
        while [[ $i > -1 && $key > ${unsortedA[$i]} ]]; # double square bracket represents Bash - bourn again Shall
            do
                echo "$l Iteration -> $i Sub iteration -> ${unsortedA[@]}"
                unsortedA[$i+1]=${unsortedA[$i]}
                i=$(expr $i - 1)
            done
        unsortedA[$i+1]=$key
        l=$(expr $l + 1)
    done

echo "Sorted array -> "${unsortedA[@]}