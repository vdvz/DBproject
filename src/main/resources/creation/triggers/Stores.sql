CREATE OR REPLACE TRIGGER tr_ai_stores before INSERT ON Stores FOR each row BEGIN if :new.id is null then SELECT sq_stores.nextval INTO :new.id FROM dual; end if; END;