#!/bin/bash

CEC=./cells-client

OS_TYPE=$1  # darwin, windows or linux

BASE_PATH=$2

PROPERTY_FILE=$3

echo "... Executing script at [${BASE_PATH}]"

function get_property
{
    grep "^$1=" "$PROPERTY_FILE" | cut -d'=' -f2
}

cd $BASE_PATH

if [ ! -f $PROPERTY_FILE ]; then
    echo "Could not find property file at ${PROPERTY_FILE}, exiting"
    exit 1
fi

if [ ! -f cells-client ]; then
    if [ $OS_TYPE = "darwin" ]; then
        wget -q -Ocells-client https://download.pydio.com/latest/cells-client/release/{latest}/darwin-amd64/cec
    elif [ $OS_TYPE = "linux" ]; then
        wget -q -Ocells-client https://download.pydio.com/latest/cells-client/release/{latest}/linux-amd64/cec
    else
        echo "This script only supports Linux and Mac for the time being"
        exit 1
    fi
    chmod u+x cells-client
else
    echo "Found an existing cells-client binary, skipping download."
fi

echo "... Using cec version: "
$CEC version

url=$(get_property serverURL)
login=$(get_property login)
pwd=$(get_property pwd)
wks=$(get_property defaultWorkspace)
skip=$(get_property skipVerify)

if [ "${skip}" = "true" ]; then
  skipVerify="--skip_verify"
fi

echo "... Configuring connection"
echo "Command: "
echo "$CEC configure client-auth --login $login --password $pwd --url "${url}" $skipVerify"
$CEC configure client-auth --login $login --password $pwd --url "${url}" $skipVerify

exit 0
