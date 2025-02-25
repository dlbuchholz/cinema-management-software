/**
 */
package cinemaManagementSoftware.impl;

import cinemaManagementSoftware.CinemaManagementSoftwarePackage;
import cinemaManagementSoftware.CinemaOwner;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cinema Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
@Entity
@Table(name = "cinema_owners")
public class CinemaOwnerImpl extends PersonImpl implements CinemaOwner {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CinemaOwnerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CinemaManagementSoftwarePackage.Literals.CINEMA_OWNER;
	}

} //CinemaOwnerImpl
