/**
 */
package cinemaManagementSoftware;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see cinemaManagementSoftware.CinemaManagementSoftwareFactory
 * @model kind="package"
 * @generated
 */
public interface CinemaManagementSoftwarePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cinemaManagementSoftware";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/cinemaManagementSoftware";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cinemaManagementSoftware";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CinemaManagementSoftwarePackage eINSTANCE = cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl
			.init();

	/**
	 * The meta object id for the '{@link cinemaManagementSoftware.impl.CinemaImpl <em>Cinema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cinemaManagementSoftware.impl.CinemaImpl
	 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getCinema()
	 * @generated
	 */
	int CINEMA = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA__NAME = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA__LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA__OWNER = 3;

	/**
	 * The feature id for the '<em><b>Hall</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA__HALL = 4;

	/**
	 * The number of structural features of the '<em>Cinema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Total Income</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA___TOTAL_INCOME = 0;

	/**
	 * The number of operations of the '<em>Cinema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link cinemaManagementSoftware.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cinemaManagementSoftware.impl.PersonImpl
	 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ID = 0;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link cinemaManagementSoftware.impl.CustomerImpl <em>Customer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cinemaManagementSoftware.impl.CustomerImpl
	 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getCustomer()
	 * @generated
	 */
	int CUSTOMER = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__ID = PERSON__ID;

	/**
	 * The feature id for the '<em><b>Ticket</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__TICKET = PERSON_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__EMAIL = PERSON_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Telephone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__TELEPHONE = PERSON_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_FEATURE_COUNT = PERSON_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_OPERATION_COUNT = PERSON_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link cinemaManagementSoftware.impl.CinemaOwnerImpl <em>Cinema Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cinemaManagementSoftware.impl.CinemaOwnerImpl
	 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getCinemaOwner()
	 * @generated
	 */
	int CINEMA_OWNER = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA_OWNER__ID = PERSON__ID;

	/**
	 * The number of structural features of the '<em>Cinema Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA_OWNER_FEATURE_COUNT = PERSON_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cinema Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA_OWNER_OPERATION_COUNT = PERSON_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link cinemaManagementSoftware.impl.TicketImpl <em>Ticket</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cinemaManagementSoftware.impl.TicketImpl
	 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getTicket()
	 * @generated
	 */
	int TICKET = 4;

	/**
	 * The feature id for the '<em><b>Screening</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TICKET__SCREENING = 0;

	/**
	 * The feature id for the '<em><b>Seat</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TICKET__SEAT = 1;

	/**
	 * The feature id for the '<em><b>Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TICKET__PRICE = 2;

	/**
	 * The feature id for the '<em><b>Is Booked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TICKET__IS_BOOKED = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TICKET__ID = 4;

	/**
	 * The number of structural features of the '<em>Ticket</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TICKET_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Ticket</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TICKET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link cinemaManagementSoftware.impl.ScreeningImpl <em>Screening</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cinemaManagementSoftware.impl.ScreeningImpl
	 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getScreening()
	 * @generated
	 */
	int SCREENING = 5;

	/**
	 * The feature id for the '<em><b>Movie</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENING__MOVIE = 0;

	/**
	 * The feature id for the '<em><b>Hall</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENING__HALL = 1;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENING__DATE = 2;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENING__START_TIME = 3;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENING__END_TIME = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENING__ID = 5;

	/**
	 * The number of structural features of the '<em>Screening</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENING_FEATURE_COUNT = 6;

	/**
	 * The operation id for the '<em>Has Started</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENING___HAS_STARTED = 0;

	/**
	 * The operation id for the '<em>Num Reservations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENING___NUM_RESERVATIONS = 1;

	/**
	 * The operation id for the '<em>Num Bookings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENING___NUM_BOOKINGS = 2;

	/**
	 * The number of operations of the '<em>Screening</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENING_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link cinemaManagementSoftware.impl.MovieImpl <em>Movie</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cinemaManagementSoftware.impl.MovieImpl
	 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getMovie()
	 * @generated
	 */
	int MOVIE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__LENGTH = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__ID = 3;

	/**
	 * The number of structural features of the '<em>Movie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Movie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link cinemaManagementSoftware.impl.CinemaHallImpl <em>Cinema Hall</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cinemaManagementSoftware.impl.CinemaHallImpl
	 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getCinemaHall()
	 * @generated
	 */
	int CINEMA_HALL = 7;

	/**
	 * The feature id for the '<em><b>Row</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA_HALL__ROW = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA_HALL__ID = 1;

	/**
	 * The number of structural features of the '<em>Cinema Hall</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA_HALL_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Is Config Complete</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA_HALL___IS_CONFIG_COMPLETE = 0;

	/**
	 * The number of operations of the '<em>Cinema Hall</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA_HALL_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link cinemaManagementSoftware.impl.SeatingRowImpl <em>Seating Row</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cinemaManagementSoftware.impl.SeatingRowImpl
	 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getSeatingRow()
	 * @generated
	 */
	int SEATING_ROW = 8;

	/**
	 * The feature id for the '<em><b>Cinemahall</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEATING_ROW__CINEMAHALL = 0;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEATING_ROW__CATEGORY = 1;

	/**
	 * The feature id for the '<em><b>Seat</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEATING_ROW__SEAT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEATING_ROW__ID = 3;

	/**
	 * The number of structural features of the '<em>Seating Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEATING_ROW_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Seating Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEATING_ROW_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link cinemaManagementSoftware.impl.SeatImpl <em>Seat</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cinemaManagementSoftware.impl.SeatImpl
	 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getSeat()
	 * @generated
	 */
	int SEAT = 9;

	/**
	 * The feature id for the '<em><b>Row</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEAT__ROW = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEAT__ID = 1;

	/**
	 * The number of structural features of the '<em>Seat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEAT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Seat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEAT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link cinemaManagementSoftware.Category <em>Category</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cinemaManagementSoftware.Category
	 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 10;

	/**
	 * Returns the meta object for class '{@link cinemaManagementSoftware.Cinema <em>Cinema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cinema</em>'.
	 * @see cinemaManagementSoftware.Cinema
	 * @generated
	 */
	EClass getCinema();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Cinema#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see cinemaManagementSoftware.Cinema#getId()
	 * @see #getCinema()
	 * @generated
	 */
	EAttribute getCinema_Id();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Cinema#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cinemaManagementSoftware.Cinema#getName()
	 * @see #getCinema()
	 * @generated
	 */
	EAttribute getCinema_Name();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Cinema#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see cinemaManagementSoftware.Cinema#getLocation()
	 * @see #getCinema()
	 * @generated
	 */
	EAttribute getCinema_Location();

	/**
	 * Returns the meta object for the reference '{@link cinemaManagementSoftware.Cinema#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see cinemaManagementSoftware.Cinema#getOwner()
	 * @see #getCinema()
	 * @generated
	 */
	EReference getCinema_Owner();

	/**
	 * Returns the meta object for the reference list '{@link cinemaManagementSoftware.Cinema#getHall <em>Hall</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Hall</em>'.
	 * @see cinemaManagementSoftware.Cinema#getHall()
	 * @see #getCinema()
	 * @generated
	 */
	EReference getCinema_Hall();

	/**
	 * Returns the meta object for the '{@link cinemaManagementSoftware.Cinema#totalIncome() <em>Total Income</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Total Income</em>' operation.
	 * @see cinemaManagementSoftware.Cinema#totalIncome()
	 * @generated
	 */
	EOperation getCinema__TotalIncome();

	/**
	 * Returns the meta object for class '{@link cinemaManagementSoftware.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see cinemaManagementSoftware.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Person#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see cinemaManagementSoftware.Person#getId()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Id();

	/**
	 * Returns the meta object for class '{@link cinemaManagementSoftware.Customer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer</em>'.
	 * @see cinemaManagementSoftware.Customer
	 * @generated
	 */
	EClass getCustomer();

	/**
	 * Returns the meta object for the reference list '{@link cinemaManagementSoftware.Customer#getTicket <em>Ticket</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ticket</em>'.
	 * @see cinemaManagementSoftware.Customer#getTicket()
	 * @see #getCustomer()
	 * @generated
	 */
	EReference getCustomer_Ticket();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Customer#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see cinemaManagementSoftware.Customer#getEmail()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_Email();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Customer#getTelephone <em>Telephone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Telephone</em>'.
	 * @see cinemaManagementSoftware.Customer#getTelephone()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_Telephone();

	/**
	 * Returns the meta object for class '{@link cinemaManagementSoftware.CinemaOwner <em>Cinema Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cinema Owner</em>'.
	 * @see cinemaManagementSoftware.CinemaOwner
	 * @generated
	 */
	EClass getCinemaOwner();

	/**
	 * Returns the meta object for class '{@link cinemaManagementSoftware.Ticket <em>Ticket</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ticket</em>'.
	 * @see cinemaManagementSoftware.Ticket
	 * @generated
	 */
	EClass getTicket();

	/**
	 * Returns the meta object for the reference '{@link cinemaManagementSoftware.Ticket#getScreening <em>Screening</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Screening</em>'.
	 * @see cinemaManagementSoftware.Ticket#getScreening()
	 * @see #getTicket()
	 * @generated
	 */
	EReference getTicket_Screening();

	/**
	 * Returns the meta object for the reference '{@link cinemaManagementSoftware.Ticket#getSeat <em>Seat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Seat</em>'.
	 * @see cinemaManagementSoftware.Ticket#getSeat()
	 * @see #getTicket()
	 * @generated
	 */
	EReference getTicket_Seat();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Ticket#getPrice <em>Price</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Price</em>'.
	 * @see cinemaManagementSoftware.Ticket#getPrice()
	 * @see #getTicket()
	 * @generated
	 */
	EAttribute getTicket_Price();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Ticket#isIsBooked <em>Is Booked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Booked</em>'.
	 * @see cinemaManagementSoftware.Ticket#isIsBooked()
	 * @see #getTicket()
	 * @generated
	 */
	EAttribute getTicket_IsBooked();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Ticket#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see cinemaManagementSoftware.Ticket#getId()
	 * @see #getTicket()
	 * @generated
	 */
	EAttribute getTicket_Id();

	/**
	 * Returns the meta object for class '{@link cinemaManagementSoftware.Screening <em>Screening</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Screening</em>'.
	 * @see cinemaManagementSoftware.Screening
	 * @generated
	 */
	EClass getScreening();

	/**
	 * Returns the meta object for the reference '{@link cinemaManagementSoftware.Screening#getMovie <em>Movie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Movie</em>'.
	 * @see cinemaManagementSoftware.Screening#getMovie()
	 * @see #getScreening()
	 * @generated
	 */
	EReference getScreening_Movie();

	/**
	 * Returns the meta object for the reference '{@link cinemaManagementSoftware.Screening#getHall <em>Hall</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Hall</em>'.
	 * @see cinemaManagementSoftware.Screening#getHall()
	 * @see #getScreening()
	 * @generated
	 */
	EReference getScreening_Hall();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Screening#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see cinemaManagementSoftware.Screening#getDate()
	 * @see #getScreening()
	 * @generated
	 */
	EAttribute getScreening_Date();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Screening#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see cinemaManagementSoftware.Screening#getStartTime()
	 * @see #getScreening()
	 * @generated
	 */
	EAttribute getScreening_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Screening#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see cinemaManagementSoftware.Screening#getEndTime()
	 * @see #getScreening()
	 * @generated
	 */
	EAttribute getScreening_EndTime();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Screening#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see cinemaManagementSoftware.Screening#getId()
	 * @see #getScreening()
	 * @generated
	 */
	EAttribute getScreening_Id();

	/**
	 * Returns the meta object for the '{@link cinemaManagementSoftware.Screening#hasStarted() <em>Has Started</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has Started</em>' operation.
	 * @see cinemaManagementSoftware.Screening#hasStarted()
	 * @generated
	 */
	EOperation getScreening__HasStarted();

	/**
	 * Returns the meta object for the '{@link cinemaManagementSoftware.Screening#numReservations() <em>Num Reservations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Num Reservations</em>' operation.
	 * @see cinemaManagementSoftware.Screening#numReservations()
	 * @generated
	 */
	EOperation getScreening__NumReservations();

	/**
	 * Returns the meta object for the '{@link cinemaManagementSoftware.Screening#numBookings() <em>Num Bookings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Num Bookings</em>' operation.
	 * @see cinemaManagementSoftware.Screening#numBookings()
	 * @generated
	 */
	EOperation getScreening__NumBookings();

	/**
	 * Returns the meta object for class '{@link cinemaManagementSoftware.Movie <em>Movie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Movie</em>'.
	 * @see cinemaManagementSoftware.Movie
	 * @generated
	 */
	EClass getMovie();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Movie#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cinemaManagementSoftware.Movie#getName()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Name();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Movie#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see cinemaManagementSoftware.Movie#getDescription()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Description();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Movie#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see cinemaManagementSoftware.Movie#getLength()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Length();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Movie#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see cinemaManagementSoftware.Movie#getId()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Id();

	/**
	 * Returns the meta object for class '{@link cinemaManagementSoftware.CinemaHall <em>Cinema Hall</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cinema Hall</em>'.
	 * @see cinemaManagementSoftware.CinemaHall
	 * @generated
	 */
	EClass getCinemaHall();

	/**
	 * Returns the meta object for the reference list '{@link cinemaManagementSoftware.CinemaHall#getRow <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Row</em>'.
	 * @see cinemaManagementSoftware.CinemaHall#getRow()
	 * @see #getCinemaHall()
	 * @generated
	 */
	EReference getCinemaHall_Row();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.CinemaHall#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see cinemaManagementSoftware.CinemaHall#getId()
	 * @see #getCinemaHall()
	 * @generated
	 */
	EAttribute getCinemaHall_Id();

	/**
	 * Returns the meta object for the '{@link cinemaManagementSoftware.CinemaHall#isConfigComplete() <em>Is Config Complete</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Config Complete</em>' operation.
	 * @see cinemaManagementSoftware.CinemaHall#isConfigComplete()
	 * @generated
	 */
	EOperation getCinemaHall__IsConfigComplete();

	/**
	 * Returns the meta object for class '{@link cinemaManagementSoftware.SeatingRow <em>Seating Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Seating Row</em>'.
	 * @see cinemaManagementSoftware.SeatingRow
	 * @generated
	 */
	EClass getSeatingRow();

	/**
	 * Returns the meta object for the reference '{@link cinemaManagementSoftware.SeatingRow#getCinemahall <em>Cinemahall</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Cinemahall</em>'.
	 * @see cinemaManagementSoftware.SeatingRow#getCinemahall()
	 * @see #getSeatingRow()
	 * @generated
	 */
	EReference getSeatingRow_Cinemahall();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.SeatingRow#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see cinemaManagementSoftware.SeatingRow#getCategory()
	 * @see #getSeatingRow()
	 * @generated
	 */
	EAttribute getSeatingRow_Category();

	/**
	 * Returns the meta object for the reference list '{@link cinemaManagementSoftware.SeatingRow#getSeat <em>Seat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Seat</em>'.
	 * @see cinemaManagementSoftware.SeatingRow#getSeat()
	 * @see #getSeatingRow()
	 * @generated
	 */
	EReference getSeatingRow_Seat();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.SeatingRow#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see cinemaManagementSoftware.SeatingRow#getId()
	 * @see #getSeatingRow()
	 * @generated
	 */
	EAttribute getSeatingRow_Id();

	/**
	 * Returns the meta object for class '{@link cinemaManagementSoftware.Seat <em>Seat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Seat</em>'.
	 * @see cinemaManagementSoftware.Seat
	 * @generated
	 */
	EClass getSeat();

	/**
	 * Returns the meta object for the reference '{@link cinemaManagementSoftware.Seat#getRow <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Row</em>'.
	 * @see cinemaManagementSoftware.Seat#getRow()
	 * @see #getSeat()
	 * @generated
	 */
	EReference getSeat_Row();

	/**
	 * Returns the meta object for the attribute '{@link cinemaManagementSoftware.Seat#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see cinemaManagementSoftware.Seat#getId()
	 * @see #getSeat()
	 * @generated
	 */
	EAttribute getSeat_Id();

	/**
	 * Returns the meta object for enum '{@link cinemaManagementSoftware.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Category</em>'.
	 * @see cinemaManagementSoftware.Category
	 * @generated
	 */
	EEnum getCategory();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CinemaManagementSoftwareFactory getCinemaManagementSoftwareFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link cinemaManagementSoftware.impl.CinemaImpl <em>Cinema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cinemaManagementSoftware.impl.CinemaImpl
		 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getCinema()
		 * @generated
		 */
		EClass CINEMA = eINSTANCE.getCinema();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CINEMA__ID = eINSTANCE.getCinema_Id();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CINEMA__NAME = eINSTANCE.getCinema_Name();
		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CINEMA__LOCATION = eINSTANCE.getCinema_Location();
		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CINEMA__OWNER = eINSTANCE.getCinema_Owner();
		/**
		 * The meta object literal for the '<em><b>Hall</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CINEMA__HALL = eINSTANCE.getCinema_Hall();
		/**
		 * The meta object literal for the '<em><b>Total Income</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CINEMA___TOTAL_INCOME = eINSTANCE.getCinema__TotalIncome();
		/**
		 * The meta object literal for the '{@link cinemaManagementSoftware.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cinemaManagementSoftware.impl.PersonImpl
		 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__ID = eINSTANCE.getPerson_Id();
		/**
		 * The meta object literal for the '{@link cinemaManagementSoftware.impl.CustomerImpl <em>Customer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cinemaManagementSoftware.impl.CustomerImpl
		 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getCustomer()
		 * @generated
		 */
		EClass CUSTOMER = eINSTANCE.getCustomer();
		/**
		 * The meta object literal for the '<em><b>Ticket</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER__TICKET = eINSTANCE.getCustomer_Ticket();
		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__EMAIL = eINSTANCE.getCustomer_Email();
		/**
		 * The meta object literal for the '<em><b>Telephone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__TELEPHONE = eINSTANCE.getCustomer_Telephone();
		/**
		 * The meta object literal for the '{@link cinemaManagementSoftware.impl.CinemaOwnerImpl <em>Cinema Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cinemaManagementSoftware.impl.CinemaOwnerImpl
		 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getCinemaOwner()
		 * @generated
		 */
		EClass CINEMA_OWNER = eINSTANCE.getCinemaOwner();
		/**
		 * The meta object literal for the '{@link cinemaManagementSoftware.impl.TicketImpl <em>Ticket</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cinemaManagementSoftware.impl.TicketImpl
		 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getTicket()
		 * @generated
		 */
		EClass TICKET = eINSTANCE.getTicket();
		/**
		 * The meta object literal for the '<em><b>Screening</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TICKET__SCREENING = eINSTANCE.getTicket_Screening();
		/**
		 * The meta object literal for the '<em><b>Seat</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TICKET__SEAT = eINSTANCE.getTicket_Seat();
		/**
		 * The meta object literal for the '<em><b>Price</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TICKET__PRICE = eINSTANCE.getTicket_Price();
		/**
		 * The meta object literal for the '<em><b>Is Booked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TICKET__IS_BOOKED = eINSTANCE.getTicket_IsBooked();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TICKET__ID = eINSTANCE.getTicket_Id();
		/**
		 * The meta object literal for the '{@link cinemaManagementSoftware.impl.ScreeningImpl <em>Screening</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cinemaManagementSoftware.impl.ScreeningImpl
		 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getScreening()
		 * @generated
		 */
		EClass SCREENING = eINSTANCE.getScreening();
		/**
		 * The meta object literal for the '<em><b>Movie</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCREENING__MOVIE = eINSTANCE.getScreening_Movie();
		/**
		 * The meta object literal for the '<em><b>Hall</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCREENING__HALL = eINSTANCE.getScreening_Hall();
		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCREENING__DATE = eINSTANCE.getScreening_Date();
		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCREENING__START_TIME = eINSTANCE.getScreening_StartTime();
		/**
		 * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCREENING__END_TIME = eINSTANCE.getScreening_EndTime();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCREENING__ID = eINSTANCE.getScreening_Id();
		/**
		 * The meta object literal for the '<em><b>Has Started</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCREENING___HAS_STARTED = eINSTANCE
				.getScreening__HasStarted();
		/**
		 * The meta object literal for the '<em><b>Num Reservations</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCREENING___NUM_RESERVATIONS = eINSTANCE
				.getScreening__NumReservations();
		/**
		 * The meta object literal for the '<em><b>Num Bookings</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCREENING___NUM_BOOKINGS = eINSTANCE
				.getScreening__NumBookings();
		/**
		 * The meta object literal for the '{@link cinemaManagementSoftware.impl.MovieImpl <em>Movie</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cinemaManagementSoftware.impl.MovieImpl
		 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getMovie()
		 * @generated
		 */
		EClass MOVIE = eINSTANCE.getMovie();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__NAME = eINSTANCE.getMovie_Name();
		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__DESCRIPTION = eINSTANCE.getMovie_Description();
		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__LENGTH = eINSTANCE.getMovie_Length();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__ID = eINSTANCE.getMovie_Id();
		/**
		 * The meta object literal for the '{@link cinemaManagementSoftware.impl.CinemaHallImpl <em>Cinema Hall</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cinemaManagementSoftware.impl.CinemaHallImpl
		 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getCinemaHall()
		 * @generated
		 */
		EClass CINEMA_HALL = eINSTANCE.getCinemaHall();
		/**
		 * The meta object literal for the '<em><b>Row</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CINEMA_HALL__ROW = eINSTANCE.getCinemaHall_Row();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CINEMA_HALL__ID = eINSTANCE.getCinemaHall_Id();
		/**
		 * The meta object literal for the '<em><b>Is Config Complete</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CINEMA_HALL___IS_CONFIG_COMPLETE = eINSTANCE
				.getCinemaHall__IsConfigComplete();
		/**
		 * The meta object literal for the '{@link cinemaManagementSoftware.impl.SeatingRowImpl <em>Seating Row</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cinemaManagementSoftware.impl.SeatingRowImpl
		 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getSeatingRow()
		 * @generated
		 */
		EClass SEATING_ROW = eINSTANCE.getSeatingRow();
		/**
		 * The meta object literal for the '<em><b>Cinemahall</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEATING_ROW__CINEMAHALL = eINSTANCE
				.getSeatingRow_Cinemahall();
		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEATING_ROW__CATEGORY = eINSTANCE.getSeatingRow_Category();
		/**
		 * The meta object literal for the '<em><b>Seat</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEATING_ROW__SEAT = eINSTANCE.getSeatingRow_Seat();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEATING_ROW__ID = eINSTANCE.getSeatingRow_Id();
		/**
		 * The meta object literal for the '{@link cinemaManagementSoftware.impl.SeatImpl <em>Seat</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cinemaManagementSoftware.impl.SeatImpl
		 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getSeat()
		 * @generated
		 */
		EClass SEAT = eINSTANCE.getSeat();
		/**
		 * The meta object literal for the '<em><b>Row</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEAT__ROW = eINSTANCE.getSeat_Row();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEAT__ID = eINSTANCE.getSeat_Id();
		/**
		 * The meta object literal for the '{@link cinemaManagementSoftware.Category <em>Category</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cinemaManagementSoftware.Category
		 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getCategory()
		 * @generated
		 */
		EEnum CATEGORY = eINSTANCE.getCategory();

	}

} //CinemaManagementSoftwarePackage
