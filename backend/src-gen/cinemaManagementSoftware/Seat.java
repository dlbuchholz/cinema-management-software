/**
 */
package cinemaManagementSoftware;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Seat</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cinemaManagementSoftware.Seat#getRow <em>Row</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Seat#getId <em>Id</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Seat#getSeatNumber <em>Seat Number</em>}</li>
 * </ul>
 *
 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getSeat()
 * @model
 * @generated
 */
public interface Seat extends EObject {
	/**
	 * Returns the value of the '<em><b>Row</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link cinemaManagementSoftware.SeatingRow#getSeats <em>Seats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row</em>' reference.
	 * @see #setRow(SeatingRow)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getSeat_Row()
	 * @see cinemaManagementSoftware.SeatingRow#getSeats
	 * @model opposite="seats" required="true"
	 * @generated
	 */
	SeatingRow getRow();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Seat#getRow <em>Row</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Row</em>' reference.
	 * @see #getRow()
	 * @generated
	 */
	void setRow(SeatingRow value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getSeat_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Seat#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Seat Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seat Number</em>' attribute.
	 * @see #setSeatNumber(int)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getSeat_SeatNumber()
	 * @model
	 * @generated
	 */
	int getSeatNumber();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Seat#getSeatNumber <em>Seat Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seat Number</em>' attribute.
	 * @see #getSeatNumber()
	 * @generated
	 */
	void setSeatNumber(int value);

} // Seat
