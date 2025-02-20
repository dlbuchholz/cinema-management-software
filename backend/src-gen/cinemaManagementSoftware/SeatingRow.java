/**
 */
package cinemaManagementSoftware;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Seating Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cinemaManagementSoftware.SeatingRow#getCinemahall <em>Cinemahall</em>}</li>
 *   <li>{@link cinemaManagementSoftware.SeatingRow#getCategory <em>Category</em>}</li>
 *   <li>{@link cinemaManagementSoftware.SeatingRow#getSeat <em>Seat</em>}</li>
 *   <li>{@link cinemaManagementSoftware.SeatingRow#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getSeatingRow()
 * @model
 * @generated
 */
public interface SeatingRow extends EObject {
	/**
	 * Returns the value of the '<em><b>Cinemahall</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link cinemaManagementSoftware.CinemaHall#getRow <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cinemahall</em>' reference.
	 * @see #setCinemahall(CinemaHall)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getSeatingRow_Cinemahall()
	 * @see cinemaManagementSoftware.CinemaHall#getRow
	 * @model opposite="row" required="true"
	 * @generated
	 */
	CinemaHall getCinemahall();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.SeatingRow#getCinemahall <em>Cinemahall</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cinemahall</em>' reference.
	 * @see #getCinemahall()
	 * @generated
	 */
	void setCinemahall(CinemaHall value);

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * The literals are from the enumeration {@link cinemaManagementSoftware.Category}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see cinemaManagementSoftware.Category
	 * @see #setCategory(Category)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getSeatingRow_Category()
	 * @model
	 * @generated
	 */
	Category getCategory();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.SeatingRow#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see cinemaManagementSoftware.Category
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(Category value);

	/**
	 * Returns the value of the '<em><b>Seat</b></em>' reference list.
	 * The list contents are of type {@link cinemaManagementSoftware.Seat}.
	 * It is bidirectional and its opposite is '{@link cinemaManagementSoftware.Seat#getRow <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seat</em>' reference list.
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getSeatingRow_Seat()
	 * @see cinemaManagementSoftware.Seat#getRow
	 * @model opposite="row" required="true"
	 * @generated
	 */
	EList<Seat> getSeat();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getSeatingRow_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.SeatingRow#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

} // SeatingRow
