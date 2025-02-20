/**
 */
package cinemaManagementSoftware;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage
 * @generated
 */
public interface CinemaManagementSoftwareFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CinemaManagementSoftwareFactory eINSTANCE = cinemaManagementSoftware.impl.CinemaManagementSoftwareFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Cinema</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cinema</em>'.
	 * @generated
	 */
	Cinema createCinema();

	/**
	 * Returns a new object of class '<em>Customer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Customer</em>'.
	 * @generated
	 */
	Customer createCustomer();

	/**
	 * Returns a new object of class '<em>Cinema Owner</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cinema Owner</em>'.
	 * @generated
	 */
	CinemaOwner createCinemaOwner();

	/**
	 * Returns a new object of class '<em>Ticket</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ticket</em>'.
	 * @generated
	 */
	Ticket createTicket();

	/**
	 * Returns a new object of class '<em>Screening</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Screening</em>'.
	 * @generated
	 */
	Screening createScreening();

	/**
	 * Returns a new object of class '<em>Movie</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Movie</em>'.
	 * @generated
	 */
	Movie createMovie();

	/**
	 * Returns a new object of class '<em>Cinema Hall</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cinema Hall</em>'.
	 * @generated
	 */
	CinemaHall createCinemaHall();

	/**
	 * Returns a new object of class '<em>Seating Row</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Seating Row</em>'.
	 * @generated
	 */
	SeatingRow createSeatingRow();

	/**
	 * Returns a new object of class '<em>Seat</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Seat</em>'.
	 * @generated
	 */
	Seat createSeat();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CinemaManagementSoftwarePackage getCinemaManagementSoftwarePackage();

} //CinemaManagementSoftwareFactory
