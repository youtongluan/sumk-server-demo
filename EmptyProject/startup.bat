
setlocal enabledelayedexpansion
echo off

rem arguments
# use your start class
set main_class=org.yx.main.SumkServer
set java=java
set opt=-Xmx1024m -Xss256k

set cur=%~dp0

%java% %opt% -cp %cur%/classes;%cur%/libs/* %main_class%
pause

