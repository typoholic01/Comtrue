-- 오라클 계정을 생성한다
CREATE USER comtrue IDENTIFIED BY comtrue;

-- 권한을 부여한다
GRANT connect, resource TO comtrue;