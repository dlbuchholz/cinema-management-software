/**
 */
package cinemaManagementSoftware;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ticket</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cinemaManagementSoftware.Ticket#getScreening <em>Screening</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Ticket#getSeat <em>Seat</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Ticket#getPrice <em>Price</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Ticket#isIsBooked <em>Is Booked</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Ticket#getId <em>Id</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Ticket#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getTicket()
 * @model
 * @generated
 */
public interface Ticket extends EObject {
	/**
	 * Returns the value of the '<em><b>Screening</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Screening</em>' reference.
	 * @see #setScreening(Screening)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getTicket_Screening()
	 * @model required="true"
	 * @generated
	 */
	Screening getScreening();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Ticket#getScreening <em>Screening</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Screening</em>' reference.
	 * @see #getScreening()
	 * @generated
	 */
	void setScreening(Screening value);

	/**
	 * Returns the value of the '<em><b>Seat</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seat</em>' reference.
	 * @see #setSeat(Seat)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getTicket_Seat()
	 * @model required="true"
	 * @generated
	 */
	Seat getSeat();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Ticket#getSeat <em>Seat</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seat</em>' reference.
	 * @see #getSeat()
	 * @generated
	 */
	void setSeat(Seat value);

	/**
	 * Returns the value of the '<em><b>Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Price</em>' attribute.
	 * @see #setPrice(double)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getTicket_Price()
	 * @model
	 * @generated
	 */
	double getPrice();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Ticket#getPrice <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Price</em>' attribute.
	 * @see #getPrice()
	 * @generated
	 */
	void setPrice(double value);

	/**
	 * Returns the value of the '<em><b>Is Booked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Booked</em>' attribute.
	 * @see #setIsBooked(boolean)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getTicket_IsBooked()
	 * @model
	 * @generated
	 */
	boolean isIsBooked();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Ticket#isIsBooked <em>Is Booked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Booked</em>' attribute.
	 * @see #isIsBooked()
	 * @generated
	 */
	void setIsBooked(boolean value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getTicket_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Ticket#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link cinemaManagementSoftware.Customer#getTicket <em>Ticket</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(Customer)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getTicket_Owner()
	 * @see cinemaManagementSoftware.Customer#getTicket
	 * @model opposite="ticket" required="true"
	 * @generated
	 */
	Customer getOwner();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Ticket#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Customer value);

} // Ticket
