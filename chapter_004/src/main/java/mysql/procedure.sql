-- DO $$ BEGIN
--         insert into books (name) values ('Procedure Book');/* тут ваш код */ END $$;

CREATE PROCEDURE test_proc()
    LANGUAGE plpgsql
AS $$
BEGIN
    CREATE TABLE a (aid int);
    CREATE TABLE b (bid int);
    COMMIT;
    CREATE TABLE c (cid int);
    ROLLBACK;
END;
$$;
