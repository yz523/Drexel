#!/bin/bash

for file in *;do
echo -n "$file"
wc <"$file" -lw
done
