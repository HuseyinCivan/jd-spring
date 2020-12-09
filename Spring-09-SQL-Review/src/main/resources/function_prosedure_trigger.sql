CREATE TABLE Towns
(
    id      SERIAL UNIQUE NOT NULL,
    code    VARCHAR(10)   NOT NULL, -- not unique
    article TEXT,
    name    TEXT          NOT NULL  -- not unique
);
insert into towns (code, article, name)
select left(md5(i::text), 10),
       md5(random()::text),
       md5(random()::text)
from generate_series(1, 1000000) s(i);

select *
from towns;
select count(*)
from towns;



explain analyze
select *
from towns
where name = '6cbac263b73929bf4417c08234f05026';

create index idx_towns_name on towns (name);

drop index if exists idx_towns_name;



explain analyze
select *
from towns
where name = 'ac638844b10d0db9488e63ae235ab47f';

explain analyze
select *
from towns
where id = '1000000';

explain analyze
select *
from towns
where name = '32bca5ed7c02af703b21cfbd89932575'
  and article = 'd48ea5ce8a4ae77c561a58abab9c457f';


create
    or
    replace function
    get_department_count_by_name(dep_name varchar)
    returns int
    language plpgsql
as
$$
declare
    department_count integer;
begin
    select count(*)
    into department_count
    from employees
    where department = dep_name;
    return department_count;
end;

$$;

select get_department_count_by_name('Toys');

create or replace function get_department(p_pattern varchar)
    returns table
            (
                employee_name  varchar,
                employee_email varchar
            )
    language plpgsql
as
$$
begin
    return query
        select first_name, email from employees where department ilike p_pattern;

end;
$$
;
select *
from get_department('%oth%');

drop function get_department(p_pattern varchar);


create or replace procedure update_department(emp_id int)
    language plpgsql
as
$$
declare
begin
    update employees set department = 'Toys' where employee_id = emp_id;
    commit;

end

$$;

call update_department(1);
select *
from employees
where employee_id = 1;


create or replace procedure transfer(sender int, receiver int, amount dec)
    language plpgsql
as
$$
declare
begin
    update employees
    set salary = salary - amount
    where employee_id = sender;

    update employees
    set salary = salary + amount
    where employee_id = receiver;
    commit;

end

$$;

call transfer(1, 2, 44000);

select *
from employees
order by employee_id;



drop table if exists mentors;

create table mentors
(
    id         int generated always as identity,
    first_name varchar(40) not null,
    last_name  varchar(40) not null,
    primary key (id)
);

drop table if exists mentor_audit;

create table mentor_audit
(
    id         int generated always as identity,
    mentor_id  int          not null,
    last_name  varchar(40)  not null,
    changed_on timestamp(6) not null

);

insert into mentors (first_name, last_name)
values ('Mike', 'Smith');

insert into mentors (first_name, last_name)
values ('Tom', 'Hanks');

create or replace function log_last_name_changes()
    returns trigger
    language plpgsql
as
$$
begin
    if new.last_name <> old.last_name
    then
        insert into mentor_audit(mentor_id, last_name, changed_on) values (old.id, old.last_name, now());
    end if;

    return new;

end;
$$;


create trigger last_name_change
    before update
    on mentors
    for each row
    execute procedure log_last_name_changes();

create trigger last_name_change2
    after update
    on mentors
    for each row
execute procedure log_last_name_changes();



update mentors
set last_name = 'XYZ'
where id=1;

select * from mentors where id=2;

drop trigger if exists last_name_change2 on mentors;





