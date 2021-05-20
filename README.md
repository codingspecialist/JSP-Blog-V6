## 테이블, 시퀀스

```sql
create table users(
  id number primary key,
  username varchar(100) not null,
  password varchar(100) not null,
  email varchar(100) not null,
  address varchar(200),
  created date
);

create table boards(
  id number primary key,
  title varchar(100) not null,
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