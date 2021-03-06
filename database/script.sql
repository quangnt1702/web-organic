USE [master]
GO
/****** Object:  Database [OrganicManagement]    Script Date: 11/27/2021 10:33:21 PM ******/
CREATE DATABASE [OrganicManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'OrganicManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\OrganicManagement.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'OrganicManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\OrganicManagement_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [OrganicManagement] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [OrganicManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [OrganicManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [OrganicManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [OrganicManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [OrganicManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [OrganicManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [OrganicManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [OrganicManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [OrganicManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [OrganicManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [OrganicManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [OrganicManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [OrganicManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [OrganicManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [OrganicManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [OrganicManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [OrganicManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [OrganicManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [OrganicManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [OrganicManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [OrganicManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [OrganicManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [OrganicManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [OrganicManagement] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [OrganicManagement] SET  MULTI_USER 
GO
ALTER DATABASE [OrganicManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [OrganicManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [OrganicManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [OrganicManagement] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [OrganicManagement] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [OrganicManagement] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [OrganicManagement] SET QUERY_STORE = OFF
GO
USE [OrganicManagement]
GO
/****** Object:  Table [dbo].[tblCategory]    Script Date: 11/27/2021 10:33:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCategory](
	[categoryID] [varchar](20) NOT NULL,
	[categoryName] [nvarchar](100) NULL,
 CONSTRAINT [PK_tblCategory] PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblDetailOrder]    Script Date: 11/27/2021 10:33:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblDetailOrder](
	[detailOrderID] [varchar](20) NOT NULL,
	[orderID] [varchar](20) NOT NULL,
	[productID] [varchar](20) NOT NULL,
	[quantity] [int] NULL,
	[price] [decimal](16, 2) NULL,
	[statusID] [varchar](20) NOT NULL,
 CONSTRAINT [PK_tblDetailOrder] PRIMARY KEY CLUSTERED 
(
	[detailOrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblOrder]    Script Date: 11/27/2021 10:33:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblOrder](
	[orderID] [varchar](20) NOT NULL,
	[userID] [varchar](20) NOT NULL,
	[recieverName] [nvarchar](50) NULL,
	[email] [varchar](50) NULL,
	[address] [nvarchar](100) NULL,
	[phoneNumber] [varchar](50) NULL,
	[totalMoney] [decimal](16, 2) NULL,
	[orderDate] [datetime] NULL,
	[statusID] [varchar](20) NOT NULL,
	[paymentStatus] [varchar](50) NOT NULL,
 CONSTRAINT [PK_tblOrder] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblProduct]    Script Date: 11/27/2021 10:33:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblProduct](
	[productID] [varchar](20) NOT NULL,
	[productName] [nvarchar](100) NOT NULL,
	[productPrice] [decimal](16, 2) NULL,
	[productQuantity] [int] NOT NULL,
	[image] [text] NULL,
	[categoryID] [varchar](20) NULL,
	[statusID] [varchar](20) NOT NULL,
	[description] [nvarchar](500) NULL,
	[createDate] [datetime] NULL,
 CONSTRAINT [PK_tblProduct] PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRoles]    Script Date: 11/27/2021 10:33:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRoles](
	[roleID] [varchar](20) NOT NULL,
	[roleName] [nvarchar](100) NULL,
 CONSTRAINT [PK_tblRoles] PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblStatus]    Script Date: 11/27/2021 10:33:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblStatus](
	[statusID] [varchar](20) NOT NULL,
	[statusName] [nvarchar](100) NULL,
 CONSTRAINT [PK_tblStatus] PRIMARY KEY CLUSTERED 
(
	[statusID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUsers]    Script Date: 11/27/2021 10:33:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUsers](
	[userID] [varchar](20) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[userName] [nvarchar](100) NOT NULL,
	[address] [nvarchar](200) NULL,
	[phoneNumber] [varchar](20) NULL,
	[roleID] [varchar](20) NOT NULL,
	[statusID] [varchar](20) NULL,
 CONSTRAINT [PK_tblUsers] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'C01', N'Groceries')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'C02', N'Juice')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'C03', N'野菜')
GO
INSERT [dbo].[tblProduct] ([productID], [productName], [productPrice], [productQuantity], [image], [categoryID], [statusID], [description], [createDate]) VALUES (N'B300', N'Assorted Coffee', CAST(35.00 AS Decimal(16, 2)), 50, N'https://i.imgur.com/x3BOc8l.jpg', N'C01', N'A', N'Neque porro quisquam est, qui dolore ipsum quia dolor sit amet, consectetur adipisci velit, sed quia non incidunt lores ta porro ame. numquam eius modi tempora incidunt lores ta porro ame.', CAST(N'2021-11-22T10:43:52.817' AS DateTime))
INSERT [dbo].[tblProduct] ([productID], [productName], [productPrice], [productQuantity], [image], [categoryID], [statusID], [description], [createDate]) VALUES (N'P02', N'Hand Sanitizer', CAST(15.00 AS Decimal(16, 2)), 35, N'https://i.imgur.com/S2LEQtz.jpg', N'C01', N'A', N'Neque porro quisquam est, qui dolore ipsum quia dolor sit amet, consectetur adipisci velit, sed quia non incidunt lores ta porro ame. numquam eius modi tempora incidunt lores ta porro ame.', CAST(N'1900-01-01T00:00:00.000' AS DateTime))
INSERT [dbo].[tblProduct] ([productID], [productName], [productPrice], [productQuantity], [image], [categoryID], [statusID], [description], [createDate]) VALUES (N'P03', N'Handpicked Red Chillies', CAST(19.00 AS Decimal(16, 2)), 40, N'https://i.imgur.com/zR9AgQZ.jpg', N'C01', N'A', N'Neque porro quisquam est, qui dolore ipsum quia dolor sit amet, consectetur adipisci velit, sed quia non incidunt lores ta porro ame. numquam eius modi tempora incidunt lores ta porro ame.', CAST(N'2021-09-03T00:00:00.000' AS DateTime))
INSERT [dbo].[tblProduct] ([productID], [productName], [productPrice], [productQuantity], [image], [categoryID], [statusID], [description], [createDate]) VALUES (N'P04', N'Natural Extracted Edible Oil', CAST(25.00 AS Decimal(16, 2)), 45, N'https://i.imgur.com/z1QDYMj.jpg', N'C01', N'A', N'Neque porro quisquam est, qui dolore ipsum quia dolor sit amet, consectetur adipisci velit, sed quia non incidunt lores ta porro ame. numquam eius modi tempora incidunt lores ta porro ame.', CAST(N'2021-09-03T00:00:00.000' AS DateTime))
INSERT [dbo].[tblProduct] ([productID], [productName], [productPrice], [productQuantity], [image], [categoryID], [statusID], [description], [createDate]) VALUES (N'P05', N'Farm Fresh Eggs', CAST(34.00 AS Decimal(16, 2)), 12, N'https://i.imgur.com/ZC7zuh5.jpg', N'C02', N'A', N'Neque porro quisquam est, qui dolore ipsum quia dolor sit amet, consectetur adipisci velit, sed quia non incidunt lores ta porro ame. numquam eius modi tempora incidunt lores ta porro ame.', CAST(N'2021-09-03T23:32:57.517' AS DateTime))
INSERT [dbo].[tblProduct] ([productID], [productName], [productPrice], [productQuantity], [image], [categoryID], [statusID], [description], [createDate]) VALUES (N'P06', N'Fresh Orange Juice', CAST(18.00 AS Decimal(16, 2)), 12, N'https://i.imgur.com/NG3Ux4u.jpg', N'C02', N'A', N'Neque porro quisquam est, qui dolore ipsum quia dolor sit amet, consectetur adipisci velit, sed quia non incidunt lores ta porro ame. numquam eius modi tempora incidunt lores ta porro ame.', CAST(N'2021-11-22T10:14:53.097' AS DateTime))
INSERT [dbo].[tblProduct] ([productID], [productName], [productPrice], [productQuantity], [image], [categoryID], [statusID], [description], [createDate]) VALUES (N'P07', N'Cashew Butter', CAST(25.00 AS Decimal(16, 2)), 34, N'https://i.imgur.com/3oKvclw.jpg', N'C01', N'A', N'Neque porro quisquam est, qui dolore ipsum quia dolor sit amet, consectetur adipisci velit, sed quia non incidunt lores ta porro ame. numquam eius modi tempora incidunt lores ta porro ame.', CAST(N'2021-11-23T22:49:36.000' AS DateTime))
INSERT [dbo].[tblProduct] ([productID], [productName], [productPrice], [productQuantity], [image], [categoryID], [statusID], [description], [createDate]) VALUES (N'P08', N'Diabetic Cookies', CAST(25.00 AS Decimal(16, 2)), 23, N'https://i.imgur.com/5SdcfsM.jpg', N'C01', N'A', N'Neque porro quisquam est, qui dolore ipsum quia dolor sit amet, consectetur adipisci velit, sed quia non incidunt lores ta porro ame. numquam eius modi tempora incidunt lores ta porro ame.', CAST(N'2021-11-23T22:51:03.000' AS DateTime))
INSERT [dbo].[tblProduct] ([productID], [productName], [productPrice], [productQuantity], [image], [categoryID], [statusID], [description], [createDate]) VALUES (N'P09', N'Fresh Organic Honey', CAST(34.00 AS Decimal(16, 2)), 25, N'https://i.imgur.com/oWdv6eI.jpg', N'C01', N'A', N'Neque porro quisquam est, qui dolore ipsum quia dolor sit amet, consectetur adipisci velit, sed quia non incidunt lores ta porro ame. numquam eius modi tempora incidunt lores ta porro ame.', CAST(N'2021-11-23T22:52:15.000' AS DateTime))
INSERT [dbo].[tblProduct] ([productID], [productName], [productPrice], [productQuantity], [image], [categoryID], [statusID], [description], [createDate]) VALUES (N'P10', N'Organic Face Scrub', CAST(35.00 AS Decimal(16, 2)), 35, N'https://i.imgur.com/cqubA5w.jpg', N'C01', N'A', N'Neque porro quisquam est, qui dolore ipsum quia dolor sit amet, consectetur adipisci velit, sed quia non incidunt lores ta porro ame. numquam eius modi tempora incidunt lores ta porro ame.', CAST(N'2021-11-23T22:56:37.000' AS DateTime))
INSERT [dbo].[tblProduct] ([productID], [productName], [productPrice], [productQuantity], [image], [categoryID], [statusID], [description], [createDate]) VALUES (N'P11', N'Pulses From Organic Farm', CAST(15.00 AS Decimal(16, 2)), 35, N'https://i.imgur.com/4Qfb3eQ.jpg', N'C01', N'A', N'Neque porro quisquam est, qui dolore ipsum quia dolor sit amet, consectetur adipisci velit, sed quia non incidunt lores ta porro ame. numquam eius modi tempora incidunt lores ta porro ame.', CAST(N'2021-11-23T22:57:08.000' AS DateTime))
GO
INSERT [dbo].[tblRoles] ([roleID], [roleName]) VALUES (N'AD', N'Admin')
INSERT [dbo].[tblRoles] ([roleID], [roleName]) VALUES (N'US', N'User')
GO
INSERT [dbo].[tblStatus] ([statusID], [statusName]) VALUES (N'A', N'Active')
INSERT [dbo].[tblStatus] ([statusID], [statusName]) VALUES (N'NA', N'Inactive')
GO
INSERT [dbo].[tblUsers] ([userID], [password], [userName], [address], [phoneNumber], [roleID], [statusID]) VALUES (N'quangnt', N'1', N'Quang', N'Quang Ngai', N'08068019067', N'AD', N'A')
INSERT [dbo].[tblUsers] ([userID], [password], [userName], [address], [phoneNumber], [roleID], [statusID]) VALUES (N'quanguuu10', N'1', N'Quang', N'Quang Ngai', N'0868019067', N'US', N'A')
GO
ALTER TABLE [dbo].[tblDetailOrder]  WITH CHECK ADD  CONSTRAINT [FK_tblDetailOrder_tblOrder] FOREIGN KEY([orderID])
REFERENCES [dbo].[tblOrder] ([orderID])
GO
ALTER TABLE [dbo].[tblDetailOrder] CHECK CONSTRAINT [FK_tblDetailOrder_tblOrder]
GO
ALTER TABLE [dbo].[tblDetailOrder]  WITH CHECK ADD  CONSTRAINT [FK_tblDetailOrder_tblProduct] FOREIGN KEY([detailOrderID])
REFERENCES [dbo].[tblProduct] ([productID])
GO
ALTER TABLE [dbo].[tblDetailOrder] CHECK CONSTRAINT [FK_tblDetailOrder_tblProduct]
GO
ALTER TABLE [dbo].[tblDetailOrder]  WITH CHECK ADD  CONSTRAINT [FK_tblDetailOrder_tblStatus] FOREIGN KEY([statusID])
REFERENCES [dbo].[tblStatus] ([statusID])
GO
ALTER TABLE [dbo].[tblDetailOrder] CHECK CONSTRAINT [FK_tblDetailOrder_tblStatus]
GO
ALTER TABLE [dbo].[tblOrder]  WITH CHECK ADD  CONSTRAINT [FK_tblOrder_tblStatus] FOREIGN KEY([statusID])
REFERENCES [dbo].[tblStatus] ([statusID])
GO
ALTER TABLE [dbo].[tblOrder] CHECK CONSTRAINT [FK_tblOrder_tblStatus]
GO
ALTER TABLE [dbo].[tblProduct]  WITH CHECK ADD  CONSTRAINT [FK_tblProduct_tblCategory] FOREIGN KEY([categoryID])
REFERENCES [dbo].[tblCategory] ([categoryID])
GO
ALTER TABLE [dbo].[tblProduct] CHECK CONSTRAINT [FK_tblProduct_tblCategory]
GO
ALTER TABLE [dbo].[tblProduct]  WITH CHECK ADD  CONSTRAINT [FK_tblProduct_tblStatus] FOREIGN KEY([statusID])
REFERENCES [dbo].[tblStatus] ([statusID])
GO
ALTER TABLE [dbo].[tblProduct] CHECK CONSTRAINT [FK_tblProduct_tblStatus]
GO
ALTER TABLE [dbo].[tblUsers]  WITH CHECK ADD  CONSTRAINT [FK_tblUsers_tblRoles] FOREIGN KEY([roleID])
REFERENCES [dbo].[tblRoles] ([roleID])
GO
ALTER TABLE [dbo].[tblUsers] CHECK CONSTRAINT [FK_tblUsers_tblRoles]
GO
ALTER TABLE [dbo].[tblUsers]  WITH CHECK ADD  CONSTRAINT [FK_tblUsers_tblStatus] FOREIGN KEY([statusID])
REFERENCES [dbo].[tblStatus] ([statusID])
GO
ALTER TABLE [dbo].[tblUsers] CHECK CONSTRAINT [FK_tblUsers_tblStatus]
GO
USE [master]
GO
ALTER DATABASE [OrganicManagement] SET  READ_WRITE 
GO
