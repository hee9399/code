// Zooming the waveform

import WaveSurfer from 'https://unpkg.com/wavesurfer.js@7/dist/wavesurfer.esm.js'

const wavesurfer = WaveSurfer.create({
  container: document.body,
  waveColor: 'rgb(200, 0, 200)',
  progressColor: 'rgb(100, 0, 100)',
  url: '/sqlice/sample/vox/PMND_Vocal_Chop_110BPM_03_Bm.wav',
  minPxPerSec: 100,
})

// Update the zoom level on slider change
wavesurfer.once('decode', () => {
  const slider = document.querySelector('input[type="range"]')

  slider.addEventListener('input', (e) => {
    const minPxPerSec = e.target.valueAsNumber
    wavesurfer.zoom(minPxPerSec)
  })
})

const playButton = document.querySelector('#play')
const forwardButton = document.querySelector('#forward')
const backButton = document.querySelector('#backward')

wavesurfer.once('decode', () => {
  document.querySelectorAll('input[type="checkbox"]').forEach((input) => {
    input.onchange = (e) => {
      wavesurfer.setOptions({
        [input.value]: e.target.checked,
      })
    }
  })

  playButton.onclick = () => {
    wavesurfer.playPause()
  }

  forwardButton.onclick = () => {
    wavesurfer.skip(5)
  }

  backButton.onclick = () => {
    wavesurfer.skip(-5)
  }
})