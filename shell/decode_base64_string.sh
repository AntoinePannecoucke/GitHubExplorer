#!/usr/bin/env bash

##
# @Description
# This script decode base64 string.
#
# @Args
# - $1 : Base64 string
#
# @Error
# - 11 : no string
##

#Test if the first arg is not missing
if [ -z "${1}" ]; then
  exit 11
fi

echo "${1}" | base64 --decode