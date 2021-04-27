USE [CarTagScanner]
GO

/****** Object:  Table [dbo].[CarImageFiles]    Script Date: 4/26/2021 9:35:19 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[CarImageFiles](
	[PLATE_ID] [int] IDENTITY(1,1) NOT NULL,
	[PLATE_NUM] [nvarchar](50) NOT NULL,
	[CAR_IMG] [varbinary](max) NOT NULL,
	[IS_ALLOWED] [nvarchar](10) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

SELECT [PLATE_ID]
      ,[PLATE_NUM]
      ,[CAR_IMG]
      ,[IS_ALLOWED]
  FROM [dbo].[CarImageFiles]

GO


UPDATE [dbo].[CarImageFiles]
   SET [PLATE_NUM] = <PLATE_NUM, nvarchar(50),>
      ,[CAR_IMG] = <CAR_IMG, varbinary(max),>
      ,[IS_ALLOWED] = <IS_ALLOWED, nvarchar(10),>
 WHERE <Search Conditions,,>
GO

INSERT INTO [dbo].[CarImageFiles]
           ([PLATE_NUM]
           ,[CAR_IMG]
           ,[IS_ALLOWED])
     VALUES
           (<PLATE_NUM, nvarchar(50),>
           ,<CAR_IMG, varbinary(max),>
           ,<IS_ALLOWED, nvarchar(10),>)
GO