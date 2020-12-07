#!/bin/sh

port="1111"

lsof -i :$port | awk '{print $8}' | sed '1d'