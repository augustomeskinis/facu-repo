#!/bin/bash
echo "opcion 1: ls, opcion 2 pwd, opcion 3: who"
case "$1" in
"1")
	ls
	;;
"2")
	pwd
	;;
"3")
	who
	;;
esac
exit 0
