#!/bin/sh

lsof -i :$1 | awk '{print $8}' | sed '1d'

