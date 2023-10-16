-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'movie_db';

DROP DATABASE movie_db;

--DROP USER movie_db_owner;
--DROP USER movie_db_appuser;
