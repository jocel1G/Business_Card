package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

/**
 * The main composable function for the Business Card application.
 * It combines the AboutCard and ContactInfo sections.
 */
@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Spacer to push the top section down
        Spacer(modifier = Modifier.weight(1f))

        // Top section with the logo, name, and title
        BusinessCardInfoApp(
            fullName = "Jennifer Doe",
            title = "Android Developer Extraordinaire",
            image = painterResource(id = R.drawable.ic_launcher_background) // Ensure this is your image resource ID
        )

        // Spacer to push the contact info to the bottom
        Spacer(modifier = Modifier.weight(1f))

        // Bottom section with contact information
        ContactInfo(
            phoneNumber = "+1 (123) 456-7890",
            socialMediaHandle = "@jenniferdev",
            emailAddress = "jennifer.doe@email.com"
        )
    }
}

/**
 * Composable for displaying the name, title, and an image (e.g., logo).
 * @param fullName The full name to display.
 * @param title The job title or description.
 * @param image The painter for the image/logo.
 */
@Composable
fun BusinessCardInfoApp(fullName: String, title: String, image: Painter) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Image/Logo
        Image(
            painter = image,
            contentDescription = "Android Logo",
            modifier = Modifier
                .size(120.dp) // Adjust size as needed
                .background(Color(0xFF073042)) // Dark blue background for the image
                .padding(8.dp) // Padding inside the image background
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Full Name
        Text(
            text = fullName,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF000000) // Black color for text
        )
        // Title
        Text(
            text = title,
            fontSize = 18.sp,
            color = Color(0xFF3ddc84) // Green color for the title, similar to Android green
        )
    }
}

/**
 * Composable for displaying contact information (phone, social media, email).
 * @param phoneNumber The phone number.
 * @param socialMediaHandle The social media handle.
 * @param emailAddress The email address.
 */
/**
 * Composable for displaying contact information, aligned to the start of the layout.
 */
@Composable
fun ContactInfo(
    phoneNumber: String,
    socialMediaHandle: String,
    emailAddress: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(bottom = 32.dp, start = 40.dp, end = 40.dp)
    ) {
        ContactRow(
            icon = Icons.Default.Phone, // Use Icons.Default for consistency with your code
            text = phoneNumber
        )
        Spacer(modifier = Modifier.height(16.dp))
        ContactRow(
            icon = Icons.Default.Share,
            text = socialMediaHandle
        )
        Spacer(modifier = Modifier.height(16.dp))
        ContactRow(
            icon = Icons.Default.Email,
            text = emailAddress
        )
    }
}

/**
 * Helper composable for a single contact item (icon + text).
 * The horizontal arrangement is now spaced to create a gap between the icon and text.
 */
@Composable
fun ContactRow(
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null, // decorative icon
            tint = Color(0xFF006D3B), // Dark green color for the icon, or use your theme color
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color(0xFF000000) // Black color for the text
        )
    }
}
