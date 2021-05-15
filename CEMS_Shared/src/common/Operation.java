package common;

/**
 * All the operation of the system
 *
 */
public enum Operation {
	WorkerLogin,
	VisitorLogin,
	Logout,
	CancellationReport,
	VisitorReport,
	TotalVisitorReport,
	UsageReport,
	MonthlyIncomeReport,	
	GetPark,
	OrderTimeValidation,
	addNewFamily,
	addNewGuide,
	GetAllParksName,
	ParkChange,
	SetChangInPark,
	GetChangInPark,
	ApplyChangInPark,
	DeleteChangInPark,
	existsOrders,
	OrdersInWaitingList,
	getDiscountOfPark,
	AlternativeDates,
	GetWaitingListIndex,
	NewOrder,

	SetNewStatusOrder,
	CancelOrder,
	AllOrdersMonth,
	VisitorPerDateReport,

	OrdersById,
	NumberOfVisitors,

	waitingList,
	OrderList,
	CancelOrderByUser,
	CancelOrderBySys,
	CancelOrderFromWaitingList,
	ExitFromWaitingListApproval,
	ApprovedOrder,
	OrderTimeValidationNotPreOrder,
	Exitpark,
	ConnectionDBFalse,
	SubNumberLogin,
	LoggedOut,
	AllOrdersMonthCancellation,
	OrdersByIDAndStayTimePerOrder,
	SpecificNumberOfVisitors




}
