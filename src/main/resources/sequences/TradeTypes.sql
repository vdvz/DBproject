DECLARE v_dummy NUMBER; BEGIN SELECT 1 INTO v_dummy FROM user_sequences WHERE sequence_name LIKE 'SQ_Trade_types'; EXCEPTION WHEN no_data_found THEN EXECUTE IMMEDIATE 'create sequence sq_Trade_types START WITH 1 INCREMENT BY 1 NOMAXVALUE'; END;