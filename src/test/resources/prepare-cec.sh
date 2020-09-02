#!/bin/bash

PROPERTY_FILE=./config.properties
CEC=./cells-client

BASE_PATH=$1

echo "... Executing script at $BASE_PATH"

function get_property
{
    grep "^$1=" "$PROPERTY_FILE" | cut -d'=' -f2
}

cd $BASE_PATH

if [ ! -f cells-client ]; then
    wget -q -Ocells-client https://download.pydio.com/latest/cells-client/release/{latest}/linux-amd64/cec
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

echo "... Configuring connection"
$CEC configure client-auth -l $login -p $pwd -u "${url}"

exit 0
