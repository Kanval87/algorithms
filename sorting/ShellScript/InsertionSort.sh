#! /bin/bash 

unsortedA=(6 3 4 1 4 2 4)
echo "Input array -> "${unsortedA[@]}

l=1
while [ $l -lt ${#unsortedA[@]} ] # ${#unsortedA[@]}
    do
        echo "$l iteration -> Array State : ${unsortedA[@]}"
        key=${unsortedA[$l]}
        i=$(expr $l - 1)
        while [[ $i > -1 && $key < ${unsortedA[$i]} ]];
            do
                unsortedA[$i+1]=${unsortedA[$i]}
                i=$(expr $i - 1)
            done
        unsortedA[$i+1]=$key
        l=$(expr $l + 1)
    done

echo "Sorted array -> "${unsortedA[@]}