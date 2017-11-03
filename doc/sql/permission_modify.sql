DELETE FROM permission
WHERE Type = 1
AND Related_Id NOT in (
	SELECT Page_Id FROM operation
);