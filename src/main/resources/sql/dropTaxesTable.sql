ALTER TABLE IF EXISTS SALESTAXES.TAXES DROP CONSTRAINT IF EXISTS TAXES_PK;
DROP INDEX IF EXISTS SALESTAXES.IDX_TAXES;
DROP TABLE IF EXISTS SALESTAXES.TAXES;