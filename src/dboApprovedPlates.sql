USE [CarTagScanner]
GO

/****** Object:  Table [dbo].[ApprovedPlates]    Script Date: 4/26/2021 9:34:27 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ApprovedPlates](
	[CAR_PLATE] [nvarchar](50) NOT NULL,
	[IS_ALLOWED] [nvarchar](20) NULL,
	[CAR_TYPE] [nvarchar](30) NULL,
	[CAR_COLOR] [nvarchar](30) NULL,
	[TIME_IN] [datetime2](7) NULL,
	[TIME_OUT] [datetime2](7) NULL,
	[CAR_NOTES] [nvarchar](200) NULL,
	[CAR_IMAGE] [varbinary](max) NULL,
	[CAR_OWNER] [nvarchar](50) NULL,
 CONSTRAINT [PK__Approved__0F2CDDD35B20BC13] PRIMARY KEY CLUSTERED 
(
	[CAR_PLATE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO


UPDATE [dbo].[ApprovedPlates]
   SET [CAR_PLATE] = <CAR_PLATE, nvarchar(50),>
      ,[IS_ALLOWED] = <IS_ALLOWED, nvarchar(20),>
      ,[CAR_TYPE] = <CAR_TYPE, nvarchar(30),>
      ,[CAR_COLOR] = <CAR_COLOR, nvarchar(30),>
      ,[TIME_IN] = <TIME_IN, datetime2(7),>
      ,[TIME_OUT] = <TIME_OUT, datetime2(7),>
      ,[CAR_NOTES] = <CAR_NOTES, nvarchar(200),>
      ,[CAR_IMAGE] = <CAR_IMAGE, varbinary(max),>
      ,[CAR_OWNER] = <CAR_OWNER, nvarchar(50),>
 WHERE <Search Conditions,,>
GO

INSERT INTO [dbo].[ApprovedPlates]
           ([CAR_PLATE]
           ,[IS_ALLOWED]
           ,[CAR_TYPE]
           ,[CAR_COLOR]
           ,[TIME_IN]
           ,[TIME_OUT]
           ,[CAR_NOTES]
           ,[CAR_IMAGE]
           ,[CAR_OWNER])
     VALUES
           (<CAR_PLATE, nvarchar(50),>
           ,<IS_ALLOWED, nvarchar(20),>
           ,<CAR_TYPE, nvarchar(30),>
           ,<CAR_COLOR, nvarchar(30),>
           ,<TIME_IN, datetime2(7),>
           ,<TIME_OUT, datetime2(7),>
           ,<CAR_NOTES, nvarchar(200),>
           ,<CAR_IMAGE, varbinary(max),>
           ,<CAR_OWNER, nvarchar(50),>)
GO

SELECT [CAR_PLATE]
      ,[IS_ALLOWED]
      ,[CAR_TYPE]
      ,[CAR_COLOR]
      ,[TIME_IN]
      ,[TIME_OUT]
      ,[CAR_NOTES]
      ,[CAR_IMAGE]
      ,[CAR_OWNER]
  FROM [dbo].[ApprovedPlates]


