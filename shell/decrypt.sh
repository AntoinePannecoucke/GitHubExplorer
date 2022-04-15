#!/usr/bin/env bash

##
# @Description
# This script decrypt with 'gpg' a file.
#
# @Args
# - $1 : password
# - $2 : input file
# - $3 : output file
#
# @Error
# - 11 : no password
# - 12 : no input file found
# - 13 : no output file found
##

#Test if the first arg is not missing
if [ -z "${1}" ]; then
  exit 11
fi

#Test if the second arg is not missing
if [ -z "${2}" ]; then
  exit 12
fi

#Test if the third arg is not missing
if [ -z "${3}" ]; then
  exit 13
fi

gpg -d --batch --passphrase "${1}" "${2}"> "${3}"