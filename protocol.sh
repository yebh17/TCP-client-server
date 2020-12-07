#!/bin/sh

lsof -i :$port | awk '{print $8}' | sed '1d'