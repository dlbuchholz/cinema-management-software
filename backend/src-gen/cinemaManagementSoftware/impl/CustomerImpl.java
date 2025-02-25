/**
 */
package cinemaManagementSoftware.impl;

import cinemaManagementSoftware.CinemaManagementSoftwarePackage;
import cinemaManagementSoftware.Customer;
import cinemaManagementSoftware.Ticket;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cinemaManagementSoftware.impl.CustomerImpl#getTicket <em>Ticket</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.CustomerImpl#getEmail <em>Email</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.CustomerImpl#getTelephone <em>Telephone</em>}</li>
 * </ul>
 *
 * @generated
 */
@Entity
@Table(name = "customers")
public class CustomerImpl extends PersonImpl implements Customer {
	/**
	 * The cached value of the '{@link #getTicket() <em>Ticket</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTicket()
	 * @generated
	 * @ordered
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = TicketImpl.class)
	protected EList<Ticket> ticket;

	/**
	 * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	@Column(nullable = false, unique = true)
	protected String email = EMAIL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTelephone() <em>Telephone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTelephone()
	 * @generated
	 * @ordered
	 */
	protected static final String TELEPHONE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTelephone() <em>Telephone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTelephone()
	 * @generated
	 * @ordered
	 */
	@Column(nullable = false)
	protected String telephone = TELEPHONE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CinemaManagementSoftwarePackage.Literals.CUSTOMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Ticket> getTicket() {
		if (ticket == null) {
			ticket = new EObjectResolvingEList<Ticket>(Ticket.class, this,
					CinemaManagementSoftwarePackage.CUSTOMER__TICKET);
		}
		return ticket;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEmail() {
		return email;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEmail(String newEmail) {
		String oldEmail = email;
		email = newEmail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.CUSTOMER__EMAIL, oldEmail,
					email));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTelephone() {
		return telephone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTelephone(String newTelephone) {
		String oldTelephone = telephone;
		telephone = newTelephone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.CUSTOMER__TELEPHONE,
					oldTelephone, telephone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.CUSTOMER__TICKET:
			return getTicket();
		case CinemaManagementSoftwarePackage.CUSTOMER__EMAIL:
			return getEmail();
		case CinemaManagementSoftwarePackage.CUSTOMER__TELEPHONE:
			return getTelephone();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.CUSTOMER__TICKET:
			getTicket().clear();
			getTicket().addAll((Collection<? extends Ticket>) newValue);
			return;
		case CinemaManagementSoftwarePackage.CUSTOMER__EMAIL:
			setEmail((String) newValue);
			return;
		case CinemaManagementSoftwarePackage.CUSTOMER__TELEPHONE:
			setTelephone((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.CUSTOMER__TICKET:
			getTicket().clear();
			return;
		case CinemaManagementSoftwarePackage.CUSTOMER__EMAIL:
			setEmail(EMAIL_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.CUSTOMER__TELEPHONE:
			setTelephone(TELEPHONE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.CUSTOMER__TICKET:
			return ticket != null && !ticket.isEmpty();
		case CinemaManagementSoftwarePackage.CUSTOMER__EMAIL:
			return EMAIL_EDEFAULT == null ? email != null
					: !EMAIL_EDEFAULT.equals(email);
		case CinemaManagementSoftwarePackage.CUSTOMER__TELEPHONE:
			return TELEPHONE_EDEFAULT == null ? telephone != null
					: !TELEPHONE_EDEFAULT.equals(telephone);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (email: ");
		result.append(email);
		result.append(", telephone: ");
		result.append(telephone);
		result.append(')');
		return result.toString();
	}

} //CustomerImpl
