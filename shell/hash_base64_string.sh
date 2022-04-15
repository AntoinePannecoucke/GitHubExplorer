#!/usr/bin/env bash

##
# @Description
# This script encode string to base64.
#
# @Args
# - $1 : string to encode
#
# @Error
# - 11 : no string
##

#Test if the first arg is not missing
if [ -z "${1}" ]; then
  exit 11
fi

echo "${1}" | base64