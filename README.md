## 테이블, 시퀀스

```sql
create table users(
  id number primary key,
  username varchar2(100) not null,
  password varchar2(100) not null,
  email varchar2(100) not null,
  address varchar2(200),
  created date
);

create table boards(
  id number primary key,
  title varchar2(100) not null,
  content clob,
  userId number,
  created date
);

CREATE SEQUENCE USERS_SEQ
  START WITH 1
  INCREMENT BY 1;
  
CREATE SEQUENCE BOARDS_SEQ
  START WITH 1
  INCREMENT BY 1;
```