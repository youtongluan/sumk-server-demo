
setlocal enabledelayedexpansion
echo off

rem arguments
set main_class=org.test.Bootstrap
set java=java
set opt=-Xmx1024m -Xss256k

set cur=%~dp0

%java% %opt% -cp %cur%/classes;%cur%/libs/* %main_class%
pause

